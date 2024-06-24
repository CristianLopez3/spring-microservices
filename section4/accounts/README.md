### Docker commands 🐋

```dockerfile

docker images

# -t = tag
docker build . -t cristianlopezcma/accounts:s4

# -p = port, -d = detach (run in background), --name = name of the container
docker run -p 8082:8082 -d cristianlopezcma/accounts:s4

docker inspect <container_id>

# -a = all, -q = quiet
docker ps



```

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
