package com.finance.photoappdiscoveryservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhotoAppDiscoveryServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoAppDiscoveryServicesApplication.class, args);
    }

}
