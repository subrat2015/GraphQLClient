package com.subrat.GraphQL_Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.subrat.GraphQL_Client.controller", "com.subrat.GraphQL_Client.service"})
public class GraphQlClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlClientApplication.class, args);
	}

}
