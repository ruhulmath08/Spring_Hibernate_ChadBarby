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

		auth.inMemoryAuthentication().withUser(users.username("reza").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("kapil").password("test123").roles("MANAGER"))
				.withUser(users.username("ruhul").password("test123").roles("ADMIN"));
	}

@Override
//Configure security of web paths in application, login, logout etc
protected void configure(HttpSecurity http) throws Exception {

	//Restrict access based on the HttpServletRequest
	http.authorizeRequests()
			//Any request to the app must be authenticated (i.e logged in)
			.anyRequest().authenticated()
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
