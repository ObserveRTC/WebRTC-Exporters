/*
 * Copyright  2020 Balazs Kreith
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.observertc.webrtc.adapters.bigquery.models;

import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.TableId;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigQueryTableImpl<T extends BigQueryEntry> implements BigQueryTable<T> {
	private static final Logger logger = LoggerFactory.getLogger(BigQueryTableImpl.class);

	private final String tableName;
	private final BigQueryService bigQueryService;
	private Deque<T> buffer = new LinkedList<>();

	public BigQueryTableImpl(BigQueryService bigQueryService,
							 String tableName
	) {
		this.tableName = tableName;
		this.bigQueryService = bigQueryService;
	}

	public void add(T entry) {
		this.buffer.addLast(entry);
	}

	public void addAndLog(T entry) {
		this.buffer.addLast(entry);
		this.logEntry(entry);
	}

	public void flush() {
		if (this.buffer.size() < 1) {
			return;
		}
		int buffered = this.buffer.size();
		TableId tableId = this.getTableId();
		InsertAllRequest.Builder builder = InsertAllRequest.newBuilder(tableId);
		while (!this.buffer.isEmpty()) {
			T entry = this.buffer.removeFirst();
			builder.addRow(entry.toMap());
		}

		InsertAllResponse response =
				this.bigQueryService.getBigQuery().insertAll(builder.build());


		if (response.hasErrors()) {
			// If any of the insertions failed, this lets you inspect the errors
			for (Map.Entry<Long, List<BigQueryError>> errorEntry : response.getInsertErrors().entrySet()) {
				logger.error("{}: {}", errorEntry.getKey(), String.join(", \n",
						errorEntry.getValue().stream().map(Object::toString).collect(Collectors.toList())));
				// inspect row error
			}
		} else {
			logger.info("To {} inserted {} rows", tableId.toString(), buffered);
		}
	}

	private TableId getTableId() {
		String projectName = this.bigQueryService.getProjectName();
		String datasetName = this.bigQueryService.getDatasetName();
		return TableId.of(projectName, datasetName, this.tableName);
	}

	private void logEntry(T entry) {
		logger.info("project: {}, dataset: {}, table {}. The row: \n {}",
				this.bigQueryService.getProjectName(),
				this.bigQueryService.getDatasetName(),
				this.tableName,
				this.mapString(entry.toMap(), "\t"));
	}

	private String mapString(Map<String, Object> map, String prefix) {

		StringBuffer resultBuffer = new StringBuffer();
		Iterator<Map.Entry<String, Object>> mapIt = map.entrySet().iterator();
		for (; mapIt.hasNext(); ) {
			Map.Entry<String, Object> entry = mapIt.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				resultBuffer.append(String.format("%s%s: null\n", prefix, key));
			} else if (value instanceof Map) {
				resultBuffer.append(String.format("%s%s: %s\n", prefix, key,
						this.mapString((Map<String, Object>) value, prefix + "\t")));
			} else {
				resultBuffer.append(String.format("%s%s: %s\n", prefix, entry.getKey(), value.toString()));
			}
		}
		return resultBuffer.toString();
	}

}