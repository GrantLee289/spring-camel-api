FROM openjdk:11

ENV APPNAME spring-camel-api

COPY ./target/${APPNAME}.jar ${APPNAME}.jar
COPY ./config/ /config

VOLUME /logs
VOLUME /from

ENTRYPOINT java -jar ${APPNAME}.jar