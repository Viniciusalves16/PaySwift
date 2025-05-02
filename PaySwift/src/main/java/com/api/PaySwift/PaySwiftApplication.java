package com.api.PaySwift;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
public class PaySwiftApplication {

	public static void main(String[] args) {
		System.out.println("iniciando aplicaçao");
		SpringApplication.run(PaySwiftApplication.class, args);
	}

}
