package spring01.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring01.model.EmailAddress;
import spring01.model.GenericInfoService;

public class SpringXMLMain {

	public static void main(String[] args) {
		
		System.out.println("Spring using XML Configuration\n");

		// load Spring XML Configuration 
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext01.xml");

		// Inversion of Control - IoC : get bean and call its method
		GenericInfoService gs1 = (GenericInfoService) context.getBean("dbServiceBean");
		GenericInfoService gs2 = (GenericInfoService) context.getBean("dbServiceBean");
		System.out.println("\nService Name: " + gs1.getServiceName());
		System.out.println("Service Name: " + gs2.getServiceName());
		System.out.println("Are two references the same bean object (prototype) ? " + (gs1 == gs2));
		
		// "emailAddrBeanConstruct": constructor injection; 
		// literal values injected (see xml config file)
		EmailAddress ea1 = (EmailAddress) context.getBean("emailAddrBeanConstruct");
		EmailAddress ea2 = (EmailAddress) context.getBean("emailAddrBeanConstruct");
		System.out.println("\nemailAddrBeanConstruct: " + ea1);
		System.out.println("emailAddrBeanConstruct: " + ea2);
		System.out.println("Are two references the same bean object (singleton) ? " + (ea1 == ea2));

		// "emailAddrBeanSetter": setter injection; 
		// values injected from a property file (see xml config file)
		EmailAddress ea = (EmailAddress) context.getBean("emailAddrBeanSetter");
		System.out.println("\nemailAddrBeanSetter: " + ea);

		// "emailServiceBean" with init-method and destroy-method (see xml config file)
		gs1 = (GenericInfoService) context.getBean("emailServiceBean");
		System.out.println("\nService Name: " + gs1.getServiceName());
		System.out.println("emailServiceBean: " + gs1);
		System.out.println();
		
		// close context
		context.close();
	}

}
