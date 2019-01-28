package com.shizhan.springcloud.euraka.eurakaserver;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurakaServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurakaServerApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}

