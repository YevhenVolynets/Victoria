package ua.victoria.app;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;





@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(this.userDetailsService)
		.passwordEncoder(passwordEncoder());
		
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
		.usernameParameter("email")
		.passwordParameter("password")
		.loginPage("/login")
		.failureUrl("/login?fail=true")
	.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/")
		.deleteCookies("JSESSIONID", "RememberMeCookie")
		.invalidateHttpSession(true)
	.and()
		.authorizeRequests()
		.antMatchers("/user").hasAnyRole("ADMIN", "USER")
		.antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().permitAll()
	/*.and()
		.exceptionHandling().accessDeniedPage("/")*/
	.and()
		.sessionManagement().maximumSessions(1)
	.and().and()
		.rememberMe()
		.rememberMeParameter("rememberMe")
		.key("super secret key")
		.rememberMeCookieName("RememberMeCookie")
		.tokenValiditySeconds(365 * 24 * 60 * 60);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	
	

}
