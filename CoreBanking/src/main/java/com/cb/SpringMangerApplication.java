package com.cb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
//(exclude={DataSourceAutoConfiguration.class})
public class SpringMangerApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringMangerApplication.class);
	}
	public static void main(String[] args) {

		SpringApplication.run(SpringMangerApplication.class, args);
	}
}
