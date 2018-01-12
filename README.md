# Consul-Java-Api
Spring boot application that uses Consul as a configuration store/administration.

---

# How to run

1. Clone repository to a local folder.
2. Build the project with `mvn clean install` from `consul-java-app` directory.
3. Then, `cd` into `docker/` folder.
4. Run `docker-compose up` to start containers.
5. Make a request to:
   `curl http://localhost:8080/v1/employee`
   
   Response will retrieve default values:
   
   ```json
   {
    "id": 1,
    "firstName": "Jon",
    "lastName": "Doe",
    "phoneNumber": 555123,
    "address": "Fake Street 1"
   }
   ```
   
5. Then, Browse to `http://localhost:8500` to get Consul Web UI console.
6. Under `key/value` section. Find the properties and change the value.
7. A new reques to `curl http://localhost:8080/v1/employee` will retrieve new values. The interval to see the new values is every
10 seconds.
