# MICROSERVICE BANK

Section 4 of microservices course, implementation of docker, spring boot, and microservices.

## Getting Started

Instructions to set up your project locally for development and testing purposes.

## Docker 🐋

### Docker Commands 🧰

To generate automatic images without a Dockerfile, you can use **jib** or **build packs**.

```shell
# List Docker images
docker images

# Build Docker image with tag
docker build . -t cristianlopezcma/accounts:s4

# Run Docker container in detached mode
docker run -p 8082:8082 -d cristianlopezcma/accounts:s4

# Inspect a Docker container
docker inspect <container_id>

# List Docker processes
docker ps -a -q
```

### Creating an Image with Maven

```shell
# Using build pack
mvn spring-boot:build-image

# Using jib
mvn compile jib:dockerBuild
```

> [!NOTE]
> Use jib if you don't want to create a Dockerfile. It's a good practice to use jib to create images, especially if you don't have Docker installed on your system.

### Pushing to Docker Hub 🚀

```shell
# Login to Docker Hub
docker login

# Push the image to Docker Hub
docker push cristianlopezcma/accounts:s4

# Pull the image from Docker Hub
docker pull cristianlopezcma/accounts:s4
```

### Docker Compose 🐋

The docker compose for this project is inside the accounts folder...

```shell
# -d = detached mode
docker compose up # start the containers
```

## Maven 🧰

```shell
# Build image with Maven
mvn spring-boot:build-image

# Clean, install, and package with Maven
mvn clean install package
```

> **Note:** You can build an image with a Dockerfile, using build packs, or using the Spring Boot plugin.

## Dependencies

```shell
spring web
spring data jpa
h2 database
lombok
actuator
devtools
validation
```

## Tips

Be careful with the libraries you use in your project. Some of them can be harmful to your project if they are not recognized by Spring, as they could cause problems in the future because they are open source.

**Model Mapper:** Use this to map the entity to DTO and vice versa. It's a good practice to use this library to avoid boilerplate code.

