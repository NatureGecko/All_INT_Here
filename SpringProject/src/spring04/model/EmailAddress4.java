package spring04.model;

import org.springframework.beans.factory.annotation.Value;

public class EmailAddress4 {
	@Value("${email.account}") private String userName;
	@Value("${email.domain}") private String domainName;

	public EmailAddress4() { }

	@Override public String toString() { return userName + "@" + domainName; }
}
