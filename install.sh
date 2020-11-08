#!/bin/bash

VERSION=0.3

docker login

docker build -f BigQueryExporter.dockerfile . -t observertc/webrtc-bigquery-exporter:$VERSION
docker push observertc/webrtc-bigquery-exporter:$VERSION
