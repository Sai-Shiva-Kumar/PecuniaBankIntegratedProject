package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootAccountCreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAccountCreationApplication.class, args);
	}
	@Bean
	   
    public RestTemplate getTemplate() {
   	return new RestTemplate();

}
}
