#!/bin/bash

VERSION=0.4

docker login

docker build -f BigQueryAdapter.dockerfile . -t observertc/webrtc-bigquery-adapter:$VERSION
docker push observertc/webrtc-bigquery-adapter:$VERSION
