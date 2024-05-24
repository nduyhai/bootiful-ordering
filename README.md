# Bootiful Ordering

## Overview

Implement a production-ready Ordering system using a microservices architecture:

- Microservices using `Spring Boot`, `Spring Cloud`, `Spring Cloud Stream`
- Database per service using `TiDB`
- Saga Pattern: Distributed transaction span multiple services.
- Transaction Outbox Pattern

## Prerequisites

- `Java 21`
- `Docker`
- `Docker-compose`


## Get Started

### Setup environment


### Setup TiDB

```bash
$ git clone https://github.com/nduyhai/tidb-docker-compose.git
$ git checkout devel
$ cd tidb-docker-compose && docker-compose pull # Get the latest Docker images
$ sudo setenforce 0 # Only on Linux
$ docker-compose up -d
$ mysql -h 127.0.0.1 -P 4000 -u root
```

#### AMD

```shell
export PLATFORM=linux/amd64 && docker-compose up -d --force-recreate
```
#### ARM

```shell
export PLATFORM=linux/arm64 && docker-compose up -d --force-recreate
```

## Observability

Access http://localhost:3000/d/bootiful_ordering/bootiful-ordering-system?orgId=1 to see the dashboard.
