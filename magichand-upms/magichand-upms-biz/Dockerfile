FROM openjdk:8-jdk-alpine
LABEL maintainer="1131960938@qq.com"
ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"
WORKDIR /home
ARG JAR_FILE=target/magichand-upms-biz.jar
COPY ${JAR_FILE} app.jar
CMD sleep 60
RUN java $JAVA_OPTS -jar app.jar