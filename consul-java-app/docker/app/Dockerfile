FROM develar/java

MAINTAINER David Cuellar, davidokun99@gmail.com

COPY consul-app.jar /usr/local/consul-app.jar
WORKDIR /usr/local/

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=qa", "consul-app.jar", "--acceptLicense", "/usr/local/"]