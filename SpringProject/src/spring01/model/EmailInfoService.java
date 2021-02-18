package spring01.model;

public class EmailInfoService implements GenericInfoService {
	
	private String name;
	private EmailAddress address;
	
	// for bean constructor injection <constructor-arg [ref|value]="..."/>
	public EmailInfoService(String name, EmailAddress address) {
		this.name = name;
		this.address = address;
	}
	
	// for bean setter injection <property name="..." [ref|value]="..."/>
	public EmailInfoService() { }
	public void setName(String name) { this.name = name; }
	public void setAddress(EmailAddress address) { this.address = address; }

	// for controlling bean life cycle: init-method and destroy-method
	public void starting() { System.out.println("email service opening"); }
	public void ending() { System.out.println("email service closing"); }
	
	@Override public String getServiceName() { return "email service"; }
	@Override public String toString() { return name + " <" + address + '>'; }
}
