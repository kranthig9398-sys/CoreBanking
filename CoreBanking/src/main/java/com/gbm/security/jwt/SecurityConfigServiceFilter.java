package com.gbm.security.jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigServiceFilter extends WebSecurityConfigurerAdapter {
	@Autowired
	private final JWTFilter jwtFilter;

	public SecurityConfigServiceFilter(JWTFilter jwtFilter) {
		this.jwtFilter = jwtFilter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/gbm/hello","/jwttoken/logintest","/jwttoken/validateToken").permitAll()
		.anyRequest().authenticated().and().formLogin().disable().httpBasic(); ;
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);    
	}
	//PURE REST API CONFIG

	/*
	 * protected void configure2(HttpSecurity http) throws Exception { http
	 * .csrf().disable() .authorizeRequests() .antMatchers("/gbm/login",
	 * "/gbm/hello").permitAll() .anyRequest().authenticated() .and()
	 * .exceptionHandling() .authenticationEntryPoint((request, response,
	 * authException) -> { response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
	 * "Unauthorized"); }); }
	 */
}