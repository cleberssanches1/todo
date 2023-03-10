package com.valdir.todo.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.valdir.todo.services.DbService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DbService dbService;

	@Bean
	public boolean instancia() {
		try {
			this.dbService.instanciaBaseDeDados();
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
