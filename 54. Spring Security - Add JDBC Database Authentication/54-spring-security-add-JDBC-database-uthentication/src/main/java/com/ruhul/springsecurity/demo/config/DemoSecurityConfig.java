package com.ruhul.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use JDBC authentication
		// tell Spring-Security to use JDBC authentication with our data source
		// no longer hard-coding user, dataSource point to the database table (user, authentication)
		auth.jdbcAuthentication().dataSource(securityDataSource);
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
			.logout().permitAll()
			// For custom access denied page
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}

}
