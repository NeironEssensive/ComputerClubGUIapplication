FROM openjdk:22-rc-jdk
WORKDIR /app
COPY out/artifacts/CompClubGUIandSpring_jar/CompClubGUIandSpring.jar /app/CompClubApp.jar
ENTRYPOINT ["java","-jar","CompClubApp.jar"]