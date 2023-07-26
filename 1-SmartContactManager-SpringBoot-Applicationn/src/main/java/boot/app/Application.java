package boot.app;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;

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
	public BeanNameViewResolver createBNVR() {
		BeanNameViewResolver b=new BeanNameViewResolver();
		b.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return b;
	}
	
	
	
	


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
