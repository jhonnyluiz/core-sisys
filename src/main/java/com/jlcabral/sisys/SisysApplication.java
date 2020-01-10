package com.jlcabral.sisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.jlcabral.core","com.jlcabral.sisys"})
public class SisysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisysApplication.class, args);
	}

}
