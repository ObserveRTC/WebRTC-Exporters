FROM gradle:6.3-jdk14 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle :reporter build --no-daemon 

FROM openjdk:14-alpine
COPY --from=build /home/gradle/src/build/libs/bigquery-*-all.jar bigquery-adapter.jar
#COPY build/libs/reporter-*-all.jar reporter.jar
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "bigquery-adapter.jar"]