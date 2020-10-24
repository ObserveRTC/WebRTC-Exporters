FROM gradle:6.3-jdk14 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle :bigquery:build --no-daemon 

FROM openjdk:14-alpine
COPY --from=build /home/gradle/src/bigquery/build/libs/bigquery-*-all.jar bigquery-exporter.jar
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "bigquery-exporter.jar"]