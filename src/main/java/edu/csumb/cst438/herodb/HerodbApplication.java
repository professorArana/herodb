package edu.csumb.cst438.herodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HerodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerodbApplication.class, args);
	}
}
