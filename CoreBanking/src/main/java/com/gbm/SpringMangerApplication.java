package com.gbm;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.twilio.Twilio;


@SpringBootApplication
public class SpringMangerApplication extends SpringBootServletInitializer {
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(SpringMangerApplication.class);
		}
		@Value("${twilio.accountSid}")
	    private String accountSid;

	    @Value("${twilio.authToken}")
	    private String authToken;
		public static void main(String[] args) {
			
			SpringApplication.run(SpringMangerApplication.class, args);
		}
		 @PostConstruct
		    public void initTwilio() {
		        Twilio.init(accountSid, authToken);
		    }
		
}
