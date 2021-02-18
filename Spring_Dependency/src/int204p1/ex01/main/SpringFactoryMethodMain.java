package int204p1.ex01.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import int204p1.ex01.model.InformationService;

public class SpringFactoryMethodMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext
				("applicationContext_FactoryMethod.xml");

		InformationService is1, is2, is3, is4;
		is1 = context.getBean("web", InformationService.class);
		is2 = context.getBean("eml", InformationService.class);		
		is3 = (InformationService) context.getBean("web");
		is4 = (InformationService) context.getBean("eml");

		System.out.println(is1.getInfoService());
		System.out.println(is2.getInfoService());
		System.out.println(is3.getInfoService());
		System.out.println(is4.getInfoService());
		System.out.println("2 web beans are the same? " + (is1 == is3));
		System.out.println("2 eml beans are the same? " + (is2 == is4));

		context.close();
	}
}
