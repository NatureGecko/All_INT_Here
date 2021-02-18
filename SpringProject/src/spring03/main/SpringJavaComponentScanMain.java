package spring03.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring01.model.GenericInfoService;
import spring02.model.EmailAddress;

public class SpringJavaComponentScanMain {

	public static void main(String[] args) {
		
		System.out.println("Spring using Java Class Configuration with Component Scanning\n");

		// load Spring Configuration from Java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SpringComponentScanConfig.class);

		// Inversion of Control - IoC : get bean and call its method
		GenericInfoService gs1 = (GenericInfoService) context.getBean("dbServiceBean");
		GenericInfoService gs2 = (GenericInfoService) context.getBean("dbServiceBean");
		System.out.println("\nService Name: " + gs1.getServiceName());
		System.out.println("Service Name: " + gs2.getServiceName());
		System.out.println("Are two references the same bean object (prototype) ? " + (gs1 == gs2));
		
		// "emailAddrBeanWithFieldInjection": field injection; 
		// literal values injected from property file (see java annotation)
		EmailAddress ea1 = (EmailAddress) context.getBean("emailAddrBeanWithFieldInjection");
		EmailAddress ea2 = (EmailAddress) context.getBean("emailAddrBeanWithFieldInjection");
		System.out.println("\nemailAddrBeanWithFieldInjection: " + ea1);
		System.out.println("emailAddrBeanWithFieldInjection: " + ea2);
		System.out.println("Are two references the same bean object (singleton) ? " + (ea1 == ea2));

		/* "emailServiceBean" with constructor injection with
		 * literal value injection (using @Value) and 
		 * object reference injection (using @Autowired @Qualifier) and
		 * @PostConstruct (equivalent to init-method in xml config) and 
		 * @PreDestroy (equivalent to destroy-method in xml config)
		 * See: spring02.model.EmailInfoService
		 */
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
