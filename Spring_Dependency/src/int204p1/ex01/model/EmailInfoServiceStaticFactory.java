package int204p1.ex01.model;

public class EmailInfoServiceStaticFactory {

	private static EmailInfoService emlService 
		= new EmailInfoService();

	public static EmailInfoService createInstance() {
		return emlService;
	}
}

