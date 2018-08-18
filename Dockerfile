FROM openjdk:8u151-jdk

ADD target/*.jar app.jar
CMD exec java $JAVA_OPTS \
    -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap \
    -Djava.security.egd=file:/dev/./urandom \
    -Djava.library.path=/ \
    -jar /app.jar $APP_ARGS

