package com.citib.arbitrage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.citib.arbitrage")
public class SpringBootAngularJsApplication
{
	//Application starts executing here
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootAngularJsApplication.class, args);
	}
}