package com.practise.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.eureka.registry.rule.AlwaysMatchInstanceStatusRule;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}
	
	@Bean
	public AlwaysMatchInstanceStatusRule statusRule() {
		return new AlwaysMatchInstanceStatusRule();
		
	}

}

