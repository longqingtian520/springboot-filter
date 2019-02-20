package com.criss.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.criss.wang.filter.**")
public class SpringbootFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFilterApplication.class, args);
	}
}
