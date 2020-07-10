package com.ab.restfulws.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		// Authentication with Roles
		authenticationManagerBuilder.inMemoryAuthentication().withUser("user1").password("{noop}user1").roles("USER")
				.and().withUser("admin1").password("{noop}password").roles("ADMIN", "USER");

	}
	// Authorization with Roles

	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().and().authorizeRequests().antMatchers("/employee/**").hasRole("USER")
				.antMatchers("/welcome/**").hasRole("USER").antMatchers("/**").hasRole("ADMIN").and().csrf().disable()
				.headers().frameOptions().disable();

	}
}
