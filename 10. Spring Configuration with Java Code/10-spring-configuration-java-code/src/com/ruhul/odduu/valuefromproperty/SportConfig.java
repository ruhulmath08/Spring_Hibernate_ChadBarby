package com.ruhul.odduu.valuefromproperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// define bean for our SadFortuneService
	// the method name("sadFortuneService") will be the bean ID
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define bean for our SwimCoach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
