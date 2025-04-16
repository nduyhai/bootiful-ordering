# Bootiful Ordering

## Overview

Implement a production-ready Ordering system using a microservices architecture:

- Microservices using `Spring Boot`
- Database per service using `postgresql`
- Saga Pattern: Distributed transaction span multiple services.
- Transaction Outbox Pattern

## Prerequisites

- `Java 21`
- `Docker`
- `Docker-compose`


## Get Started

### Setup environment

#### AMD

#### Linux
```shell
export PLATFORM=linux/amd64 && docker-compose up -d --force-recreate
```
#### Window 
```shell
set PLATFORM=linux/amd64 && docker-compose up -d --force-recreate
```
#### ARM

```shell
export PLATFORM=linux/arm64 && docker-compose up -d --force-recreate
```

## Observability

Access http://localhost:3000/d/bootiful_ordering/bootiful-ordering-system?orgId=1 to see the dashboard.

## Service Breakdown

* Order Service: Handles order creation, management, and status updates. It processes incoming orders and orchestrates actions like order validation and status tracking.
* Customer Service: Manages customer information, including registration, authentication, and preferences. This service authenticates users and verifies that they have the necessary permissions to place orders.
* Restaurant Service: Maintains restaurant details, menus, and availability. This service allows the system to retrieve restaurant data and updates menu information for orders.
* Inventory Service: Manages inventory details to track available items for orders. The service ensures that only available items are shown, and deducts inventory on order placement.
* Payment Service: Processes payments and handles refunds if necessary. This service integrates with third-party payment processors and manages payment validation.
* Delivery Service: Manages delivery details and driver assignment. The service coordinates with external or internal delivery partners to schedule and track deliveries.
* Notification Service: Handles notifications to customers and restaurants (e.g., order confirmation, delivery updates). Notifications can be sent via SMS, email, or in-app messaging.
* Reporting and Analytics Service: Collects data on orders, customer preferences, and delivery times for business insights and performance analytics.