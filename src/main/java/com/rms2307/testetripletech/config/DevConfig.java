package com.rms2307.testetripletech.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rms2307.testetripletech.services.CSVService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private CSVService csvConfig;
	
	@Bean
	public boolean instantiateDatebase() throws ParseException {
		csvConfig.adicionarAgendamento();
		csvConfig.atualizarAgendamento();
		return true;
	}

}
