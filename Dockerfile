FROM timveil/oo-docker-base-alpine-oracle

LABEL maintainer="tjveil@gmail.com"

ARG PROJECT_DIR=/webhook-example

RUN mkdir $PROJECT_DIR

ENV JAVA_HOME /usr/lib/jvm/java-1.8.0-openjdk
ENV PATH $JAVA_HOME/bin:$PATH

# copy source code to container
ADD .mvn $PROJECT_DIR/.mvn
ADD mvnw $PROJECT_DIR
ADD mvnw.cmd $PROJECT_DIR
ADD src $PROJECT_DIR/src
ADD pom.xml $PROJECT_DIR

# fixing a wierd issue i had running from windows
RUN sed -i 's/\r$//' $PROJECT_DIR/mvnw && chmod a+x $PROJECT_DIR/mvnw

WORKDIR $PROJECT_DIR

# package generator
RUN ./mvnw clean package -DskipTests

# port for embedded Jetty
EXPOSE 8090

ENTRYPOINT java -jar target/*.jar