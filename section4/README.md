### Docker commands 🐋

To generate automatic images without a docker file you can use **jib** or **build packs**

```shell
docker images
# -t = tag
docker build . -t cristianlopezcma/accounts:s4
# -p = port, -d = detach (run in background), --name = name of the container
docker run -p 8082:8082 -d cristianlopezcma/accounts:s4
docker inspect <container_id>
# -a = all, -q = quiet
docker ps
```

Create a **image with Maven**:
```shell
mvn spring-boot:build-image # build packer use case
mvn compile jib:dockerBuild # jib use case
```

>[!IMPORTANT]
> Use jib if you don't want to create a Dockerfile, it is a good practice to use jib to create images, and if you don't have docker in your system jib is a good option.

### Maven commands 🧰

```shell
# Look at the pom.xml file of loans to see the build configuration for the image
mvn spring-boot:build-image
mvn clean install package
```

>[!NOTE]
> You can build a image with a Dockerfile, using buildpacks or using the plugin of spring-boot.

### Dependencies

```shell
spring web
spring data jpa
h2 database
lombok
actuator
devtools
validation
```


### Tips

Take care with the libraries that you are using in your project. Some of them can be harmful to your project, because
if they are not recognized by spring, it could cause some problems in the future because they are open source.

**Model Mapper**: use this to map the entity to dto and vice versa. It is a good practice to use this library to avoid boilerplate code.
