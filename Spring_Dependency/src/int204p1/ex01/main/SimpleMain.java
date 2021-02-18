package int204p1.ex01.main;

import int204p1.ex01.model.EmailInfoService;
import int204p1.ex01.model.InformationService;
import int204p1.ex01.model.WebInfoService;

public class SimpleMain {

	public static void main(String[] args) {
		InformationService is1 = new WebInfoService();
		InformationService is2 = new EmailInfoService();
		
		System.out.println(is1.getInfoService());
		System.out.println(is2.getInfoService());
	}
}
