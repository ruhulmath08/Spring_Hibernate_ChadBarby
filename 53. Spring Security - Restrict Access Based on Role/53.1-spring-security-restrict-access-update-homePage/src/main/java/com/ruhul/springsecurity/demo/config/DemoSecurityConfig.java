package com.ruhul.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in-memory authentication

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
			.withUser(users.username("susan").password("test123").roles("ADMIN", "EMPLOYEE"));
	}

	@Override
	//Configure security of web paths in application, login, logout etc
	protected void configure(HttpSecurity http) throws Exception {
	
		//Restrict access based on the HttpServletRequest
		http.authorizeRequests()
				// Restrict access based on roles
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			//We are customizing the form login process
			.formLogin()
				// Show our custom form at the request mapping "/showMyLoginPage"
				.loginPage("/showMyLoginPage")
				// Login form should POST data to this URL for processing (check user id and password)
				.loginProcessingUrl("/authenticateTheUser")
				// Allow everyone to see login page. No need to be logged in.
				.permitAll()
			// add logout support for this given application
			.and()
			.logout().permitAll();
	}

}