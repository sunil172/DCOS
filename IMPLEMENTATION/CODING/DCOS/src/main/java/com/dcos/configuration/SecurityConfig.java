package com.dcos.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Configuration
	@Order(1)
	public static class adminconfigurations extends WebSecurityConfigurerAdapter {
		public adminconfigurations() {
			super();
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/admin/loginAdmin","/user/register","/signup").permitAll()
					.antMatchers("/admin/*","/admin/**").hasRole("ADMIN").anyRequest()
					.authenticated().and().formLogin().loginPage("/admin/loginAdmin")
					.loginProcessingUrl("/admin/admin_login").failureUrl("/admin/loginAdmin?error=loginError")
					.defaultSuccessUrl("/admin/adminPage")
					.and().logout().logoutUrl("/admin_logout").logoutSuccessUrl("/protectedLinks")
					.deleteCookies("JSESSIONID")

					.and().exceptionHandling().accessDeniedPage("/403")

					.and().csrf().disable();
		}
	}

	@Configuration
	@Order(2)
	public static class userconfigurations extends WebSecurityConfigurerAdapter {
		public userconfigurations() {
			super();
		}

		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/user*").authorizeRequests().anyRequest().hasRole("USER")

					.and().formLogin().loginPage("/loginUser").loginProcessingUrl("/user_login")
					.failureUrl("/loginUser?error=loginError").defaultSuccessUrl("/userPage")

					.and().logout().logoutUrl("/user_logout").logoutSuccessUrl("/protectedLinks")
					.deleteCookies("JSESSIONID")

					.and().exceptionHandling().accessDeniedPage("/403")

					.and().csrf().disable();
		}

	}

	@Autowired
	public void configureGloble(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}

	@Bean
	public static PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
