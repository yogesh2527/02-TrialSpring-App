package com.assimilate.springboot.web.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable(); // http.antMatcher("/employees/**"
	 * ).authorizeRequests().anyRequest().hasRole("ADMIN").and().httpBasic(); // }
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http
				.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/register","/registert").permitAll()
				.antMatchers("/students").hasRole("ADMIN").anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.and()
				.logout().logoutUrl("/perform_logout").invalidateHttpSession(true).permitAll();
		


		

	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");

		// String encode=bCryptPasswordEncoder().encode("tej");
//			System.out.println(encode);
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	
}
