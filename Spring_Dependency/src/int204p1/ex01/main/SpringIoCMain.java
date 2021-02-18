package int204p1.ex01.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import int204p1.ex01.model.InformationService;

public class SpringIoCMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		InformationService is1 = context.getBean("web", InformationService.class);
		InformationService is2 = (InformationService) context.getBean("eml");
		
		System.out.println(is1.getInfoService());
		System.out.println(is2.getInfoService());

		context.close();
	}

}
