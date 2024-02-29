**JOB-MICROSERVICES**

**Description:** This project is developed using Spring Boot and follows a microservices architecture. The project includes the following components:

- **Eureka** 
- **Zipkin** 
- **Actuator** 
- **OpenFeign** 
- **RabbitMQ** 
- **Docker** 
- **Kubernetes** 
- **API Gateway** 
- **PostgreSQL**

**Microservices** 
- **Job** 
- **Company** 
- **Review** 

**Resilience4j** :
Resilience4j library is used to implement resilience strategies between the Company and Review microservices.

**Installation** 
Follow the steps below to set up and run the project:

**Eureka Service Registry:** 
- Navigate to the service-registry directory. 
- Run the Eureka service registry application.

**Zipkin Distributed Tracing:** 
- Navigate to the zipkin directory. 
- Run the Zipkin distributed tracing server.

**Config Server:** 
- Navigate to the config-server directory. 
- Run the Config Server application.

**Microservices:** 
- Navigate to each microservice directory (jobms, companyms, review-ms). 
- Run each microservice application.

**API Gateway:** 
- Navigate to the gateway directory. 
- Run the API Gateway application.

**Dockerization:** 
- Dockerize each microservice. 
- Build Docker images for each microservice. 
- Run Docker containers for each microservice.

**Kubernetes Deployment:** 
- Deploy the Dockerized microservices to Kubernetes.

**Database Setup:** 
- Set up and configure PostgreSQL database. 
- Update database configurations in microservices.

**Run the Application:** 

Once all components are set up, you can access the application through the API Gateway or directly through microservices.
Additionally, Kubernetes configurations are available in the `application-k8s.yml` file. You can deploy and run the application on Kubernetes using these configurations. The Docker file is also provided for containerization.
