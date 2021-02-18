package spring02.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("emailAddrBeanWithFieldInjection")
@Scope("singleton")
public class EmailAddress {

	// field injection; even private fields are possible.
	@Value("${email.account}") private String userName; 
	@Value("${email.domain}") private String domainName;

	public EmailAddress() { }
	@Override public String toString() { return userName + "@" + domainName; }
}
