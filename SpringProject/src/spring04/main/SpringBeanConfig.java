package spring04.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import spring01.model.DbInfoService;
import spring01.model.EmailAddress;
import spring01.model.GenericInfoService;
import spring04.model.EmailAddress4;
import spring04.model.EmailInfoService4;
import spring04.model.PhoneInfoService4;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringBeanConfig { 
	
	// method name is the name of the bean
	
	@Bean
	@Scope("prototype")
	public GenericInfoService dbServiceBean() {
		return new DbInfoService();
	}
	
	@Bean
	@Scope("singleton")
	public EmailAddress emailAddrBeanConstruct() {
		return new EmailAddress("sit", "kmutt.ac.th");
	}

	@Bean
	@Scope("singleton")
	public EmailAddress4 emailAddrBeanWithFieldInjection() {
		return new EmailAddress4();
	}
	
	@Bean
	@Scope("singleton")
	public GenericInfoService emailServiceBean() {
		return new EmailInfoService4();
	}
	
	@Bean
	@Scope("singleton")
	public GenericInfoService phoneServiceBean() {
		return new PhoneInfoService4();
	}
}
