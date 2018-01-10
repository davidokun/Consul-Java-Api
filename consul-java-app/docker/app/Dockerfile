FROM develar/java

MAINTAINER David Cuellar, davidokun99@gmail.com

RUN mkdir /usr/local/consul-app

WORKDIR /usr/local/consul-app

ENTRYPOINT ["java", "-jar", "consul-app.jar", "--acceptLicense", "/usr/local/consul-app"]