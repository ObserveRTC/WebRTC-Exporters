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

package org.observertc.webrtc.adapters.bigquery;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceReadyEvent;
import javax.inject.Singleton;
import org.observertc.webrtc.adapters.bigquery.models.BigQueryServiceSchemaCheckerJob;
import org.observertc.webrtc.common.jobs.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Requires(notEnv = Environment.TEST) // Don't load data in tests.
public class ServiceReadyListener implements ApplicationEventListener<ServiceReadyEvent> {
	private static final Logger logger = LoggerFactory.getLogger(ServiceReadyListener.class);

	private Job job;

	public ServiceReadyListener(ReporterConfig config,
								BigQueryServiceSchemaCheckerJob bigQueryServiceSchemaCheckerJob) {
		ConfigProfile profile = ConfigProfile.fromProfile(config.profile);
		new ConfigProfileProcessor() {
			@Override
			public void actionOnBigQuery() {
				job = bigQueryServiceSchemaCheckerJob;
			}
		}.accept(profile);
		this.job = bigQueryServiceSchemaCheckerJob;
		this.init();
	}


	private void init() {

	}

	@Override
	public void onApplicationEvent(ServiceReadyEvent event) {
		this.job.perform();
	}
}
