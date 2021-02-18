package spring04.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import spring01.model.GenericInfoService;

public class EmailInfoService4 implements GenericInfoService {
	
	private String name;
	private EmailAddress4 address;
	
	// setter injection with literal value and object reference
	public EmailInfoService4() { }	
	@Value("School of Information Technology")
	public void setName(String name) { this.name = name; }
	@Autowired @Qualifier("emailAddrBeanWithFieldInjection")
	public void setEmailAddress4(EmailAddress4 address) { this.address = address; }
	
	@Override public String getServiceName() { return "email service"; }
	@Override public String toString() { return name + " <" + address + '>'; }

	/*
	 * To control bean life cycle, use @PostContruct and @PreDestroy
	 * However, these two annotations are bundled in the spring library. 
	 * So, an additional task is required.
	 * 1. download jar file for @PostConstruct and @PreDestroy annotations
	 * https://search.maven.org/remotecontent?filepath=javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2.jar
	 * 2. copy/paste "javax.annotation-api-1.3.2.jar" file into the lib folder
	 * 3. add the jar file (in the lib folder) to the build path
	 */
	@PostConstruct public void starting() { System.out.println("email service4 opening"); }
	@PreDestroy public void ending() { System.out.println("email service4 closing"); }
}
