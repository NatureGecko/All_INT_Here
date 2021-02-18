package spring04.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring01.model.EmailAddress;
import spring01.model.GenericInfoService;
import spring04.model.EmailAddress4;

public class SpringBeanMain {

	public static void main(String[] args) {
		
		System.out.println("Spring Bean Configuration using Java Class\n");

		// load Spring Configuration from Java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SpringBeanConfig.class);

		// Inversion of Control - IoC : get bean and call its method
		GenericInfoService gs1 = (GenericInfoService) context.getBean("dbServiceBean");
		GenericInfoService gs2 = (GenericInfoService) context.getBean("dbServiceBean");
		System.out.println("\nService Name: " + gs1.getServiceName());
		System.out.println("Service Name: " + gs2.getServiceName());
		System.out.println("Are two references the same bean object (prototype) ? " + (gs1 == gs2));
		
		// "emailAddrBeanConstruct": constructor injection; 
		// literal values injected from property file (see java annotation)
		EmailAddress ea1 = (EmailAddress) context.getBean("emailAddrBeanConstruct");
		EmailAddress ea2 = (EmailAddress) context.getBean("emailAddrBeanConstruct");
		System.out.println("\nemailAddrBeanConstruct: " + ea1);
		System.out.println("emailAddrBeanConstruct: " + ea2);
		System.out.println("Are two references the same bean object (singleton) ? " + (ea1 == ea2));

		// "emailAddrBeanWithFieldInjection": field injection; 
		EmailAddress4 ea4 = (EmailAddress4) context.getBean("emailAddrBeanWithFieldInjection");
		System.out.println("\nemailAddrBeanWithFieldInjection: " + ea4);
		
		// "emailServiceBean" with constructor injection
		// literal value and bean injection
		gs1 = (GenericInfoService) context.getBean("emailServiceBean");
		System.out.println("\nService Name: " + gs1.getServiceName());
		System.out.println("emailServiceBean: " + gs1);

		// "phoneServiceBean" with setter/method injection
		gs2 = (GenericInfoService) context.getBean("phoneServiceBean");
		System.out.println("\nService Name: " + gs2.getServiceName());
		System.out.println("phoneServiceBean: " + gs2);
		System.out.println();

		// close context
		context.close();
	}

}
