FROM gradle:5.3-jdk11-slim as builder

# Copy local code to the container image.
WORKDIR /app
COPY build.gradle .
COPY src ./src

# Build a release artifact.
RUN gradle clean build

FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
COPY --from=builder /app/build/libs/fff-product-*-all.jar fff-product.jar
EXPOSE 8080
CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar fff-product.jar