## Dependencies

```shell
spring web
spring data jpa
h2 database
lombok
actuator
devtools
```


### Libraries

Take care with the libraries that you are using in your project. Some of them can be harmful to your project, because
if they are not recognized by spring, it could cause some problems in the future because they are open source.

**Model Mapper**: use this to map the entity to dto and vice versa. It is a good practice to use this library to avoid boilerplate code.
