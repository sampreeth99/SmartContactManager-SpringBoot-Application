package boot.app.security.config;

import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.util.encoders.Base64Encoder;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import boot.app.user.service.UserCredentialService;

@Configuration
@EnableWebSecurity
public class SmartContactSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserCredentialService serv;
	
	@Bean
	public DaoAuthenticationProvider create() {
		DaoAuthenticationProvider d=new DaoAuthenticationProvider();
		d.setUserDetailsService(serv);
		
		BCryptPasswordEncoder b=new BCryptPasswordEncoder();
		
		d.setPasswordEncoder(b);
		
		return d;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(create());
		
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/contactManager/common","/user/register").permitAll()
		.antMatchers("/contactManager/").authenticated()
		.antMatchers("/management/add").authenticated()
		
		
		.and().formLogin()
		.defaultSuccessUrl("/contactManager/", true)
		.loginPage("/showlogin")
		.loginProcessingUrl("/login")
		.failureUrl("/showlogin?error")
		
		
		.and().rememberMe()
		.and().exceptionHandling().accessDeniedPage("/user/denied")
		
		
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/showlogin?logout")
		;
		
		}
}
