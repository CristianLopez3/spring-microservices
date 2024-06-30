# Microservices

microservices with java spring boot, docker, and kubernetes...

### Important Commits

Look here the most important commits to look something, due to I don't want to upload a complete folder for each section this is managed by commits...

1. [First Docker SetUp](https://github.com/CristianLopez3/spring-microservices/tree/b7db1eb14c83e654dcb7f244eb2959c4efa0ce33)
2. [Profiles and Environment](https://github.com/CristianLopez3/spring-microservices/tree/7a8767083ddf5378209694b80300fe4df2079290/bank-project-v1)

### MySQL

run mysql container

```bash
docker run -p 3307:3306 --name accountsdb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=accountsdb -d mysql 
```

### Hook deck

go to [hookdeck console](https://console.hookdeck.com/) and follow the process to test a webhook with 
github and hookdeck, this is very important for our microservices to be able to communicate with each other.
    