FROM openjdk:11 as build

WORKDIR /build

COPY ./ ./

RUN ./gradlew bootjar

FROM openjdk:11.0.6-jre

WORKDIR /app

COPY --from=build /build/build/libs/*.jar ./app.jar

ENTRYPOINT java -jar ./app.jar

