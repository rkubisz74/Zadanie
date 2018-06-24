package pl.rkdev.zadanie;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import pl.rkdev.zadanie.filters.CharsetFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("user")
				.password("{noop}test")
				.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/beers", "/shutdown").authenticated()
			.and()
			.httpBasic()
			.and()
			.addFilterBefore(new CharsetFilter(), ChannelProcessingFilter.class);
		http.csrf().disable();
	}
}
