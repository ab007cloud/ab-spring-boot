package com.ab.restfulws;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class AbSpringBootEmployeeServiceApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbSpringBootEmployeeServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AbSpringBootEmployeeServiceApplication.class, args);
	}

	/* i18n support */
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;

	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("CommandLineRunner is executed when the applicationContext is loaded");

	}

}
