package com.example.jedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.jedis")
@EnableSwagger2
public class JedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(JedisApplication.class, args);
	}
}
