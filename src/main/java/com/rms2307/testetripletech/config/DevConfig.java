package com.rms2307.testetripletech.config;

import java.text.ParseException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

	@Bean
	public boolean instantiateDatebase() throws ParseException {
		return true;
	}

}
