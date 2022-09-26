package com.teste.Controle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();

		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("password").roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> {
			auth.antMatchers("/").permitAll();
			auth.antMatchers("/usuario").hasRole("ADMIN");
			auth.antMatchers("/usuario/novo").hasRole("ADMIN");
			auth.antMatchers("/presenca/**").hasRole("ADMIN");
			auth.antMatchers("/usuario/role").hasRole("ADMIN");
		}).httpBasic(Customizer.withDefaults()).build();
	}

}
