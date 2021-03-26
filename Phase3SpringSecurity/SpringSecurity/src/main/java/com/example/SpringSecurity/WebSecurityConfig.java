package com.example.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter		//for configuring the spring security
{
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()					//permit all users to these urls
				.anyRequest().authenticated()
				.and()
					.formLogin()
		            .loginPage("/login")								//set login page
		            .defaultSuccessUrl("/home")							//set page to be redirected to upon successful login
		            .failureUrl("/credentialFail")						//url to be sent to upon failure to log in
		            .permitAll()
		        .and()
		            .logout()
		            .logoutSuccessUrl("/login?logout=true")				//url upon successful logout
		            .invalidateHttpSession(true)
		            .permitAll()
		        .and()
		            .csrf()
		            .disable();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService()						//sets a hard-coded in-memory user
	{
		UserDetails user =
			User.withDefaultPasswordEncoder()
				.username("user")										//set username to user
				.password("pass")										//set password to pass
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}