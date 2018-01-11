# Consul-Java-Api
Spring boot application that uses Consul as a configuration store/administration.

---

# How to run

1. Clone repository to a local folder.
2. Build the project with `mvn clean install` from `consul-java-app` directory.
3. Then, `cd` into `docker/` folder.
4. Run `docker-compose up` to start containers.
5. Browse to `http://localhost:8500` to get Consul Web UI console.
6. Create a new properties values in `key/value` section.