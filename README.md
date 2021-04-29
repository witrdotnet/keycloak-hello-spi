# Keycloak SPI implementation example

This project is an example of developed, deployed and consumed SPI implementation for keycloak.

> **Keycloak Service Provider Interfaces (SPI)**
Keycloak is designed to cover most use-cases without requiring custom code, but we also want it to be customizable. To achieve this Keycloak has a number of Service Provider Interfaces (SPI) for which you can implement your own providers.

For more information, see [Keycloak docs SPI](https://www.keycloak.org/docs/latest/server_development/#_providers)

## Start keycloak with our hello SPI implementation

* build hello-spi java project

```sh
mvn package
```

* launch docker compose

```sh
docker-compose up -d
```

## Check deployed hello SPI

There are several ways to check deployed service:

**1. Check with keycloak UI**

* browse <http://localhost:8080>
* login as admin/admin
* drop down account menu "Admin" and select "Server Info"
* select tab "Providers"
* search "hello" :

| SPI | Providers |
|:-|:-:|
| realm-restapi-extension | hello |

**2. Check in keycloak logs**

* Command

```sh
docker-compose logs | grep "helo-spi"
```

* Result

```sh
Starting deployment of "hello-spi-1.0-SNAPSHOT.jar" (runtime-name: "hello-spi-1.0-SNAPSHOT.jar")
Deploying Keycloak provider: hello-spi-1.0-SNAPSHOT.jar
Deployed "hello-spi-1.0-SNAPSHOT.jar" (runtime-name : "hello-spi-1.0-SNAPSHOT.jar")
```

### Consume hello service

* Command

```sh
curl -X GET \
  -d "client_id=admin-cli" \
  -d "username=admin" \
  -d "password=admin" \
  -d "grant_type=password" \
  http://localhost:8080/auth/realms/master/witrdotnet/hello
```

* Result:

```sh
Hello from realm master. I count 1 user(s).
```
