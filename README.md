### busca-medico-app

Microsserviço desenvolvido para busca de médicos para o projeto **Health&Med** - HACKATHON SOAT 2024.


**Sobre o projeto**

* Spring-boot 3 com Java 17
* Banco de dados MariaDB
* Path: /busca-medico-app
* Porta: 8080


**Requisitos para executar**

- Criação do banco de dados

```
$ docker run --detach --name mariadb-medico-db -p 3306:3306 --env MARIADB_DATABASE=medicodb --env  MARIADB_USER=mariadb --env MARIADB_PASSWORD=root --env MARIADB_ROOT_PASSWORD=root mariadb:latest
```

**Executar**

```
$ mvn clean install
```

```
$ spring-boot:run
```

**Swagger**

[Link Swagger](http://localhost:8080/busca-medico-app/swagger-ui/swagger-ui/index.html)
