FROM openjdk:11

ENV APPNAME spring-camel-api

EXPOSE 8084/tcp
EXPOSE 8085/tcp

COPY ./target/${APPNAME}.jar ${APPNAME}.jar
COPY ./config/ /config

VOLUME /logs
VOLUME /to

ENTRYPOINT java -jar ${APPNAME}.jar