package boot.app;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class Application {
	
	@Bean("localeResolver")
	public SessionLocaleResolver createSessionLocale() {
		SessionLocaleResolver s=new SessionLocaleResolver();
		s.setDefaultLocale(new Locale("en", "US"));
		return s;
	}
	
	

	@Bean
	public LocaleChangeInterceptor createLocalInterceptor() {
		LocaleChangeInterceptor l=new LocaleChangeInterceptor();
		l.setParamName("lang");
		return l;
	}
	
	

	@Bean
	public BCryptPasswordEncoder createEncoder() {
		BCryptPasswordEncoder b=new BCryptPasswordEncoder();
		return b;
	}
	
	


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
