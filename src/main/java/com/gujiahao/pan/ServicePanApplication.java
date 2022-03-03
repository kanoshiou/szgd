package com.gujiahao.pan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;

@SpringBootApplication
@ComponentScan(basePackages = "com.gujiahao")
@EnableSwagger2
public class ServicePanApplication {
    public static void main(String[] args) {
        File fileTemp = new File(System.getProperty("user.dir") + "\\" + "temp");
        if (!fileTemp.exists()) {
            fileTemp.mkdir();
        }

        SpringApplication.run(ServicePanApplication.class, args);
    }
}
