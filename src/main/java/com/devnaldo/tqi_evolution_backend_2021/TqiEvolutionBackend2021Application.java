package com.devnaldo.tqi_evolution_backend_2021;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@SpringBootApplication
@Configuration
@EnableWebSecurity
public class TqiEvolutionBackend2021Application  extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(TqiEvolutionBackend2021Application.class, args);

	}
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin(form -> form
						.loginPage("/login")
						.permitAll()
						.defaultSuccessUrl("/home", true)
				)
				.logout(logout -> logout.logoutUrl("/logout"))
				.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
				.ignoring()
				.antMatchers("/cliente");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(encoder);
	}

}

