package spring01.model;

public class EmailAddress {
	private String userName;
	private String domainName;

	// for constructor injection
	public EmailAddress(String userName, String domainName) {
		this.userName = userName;
		this.domainName = domainName;
	}

	// for setter injection
	public EmailAddress() { }
	public void setUserName(String userName) { this.userName = userName; }
	public void setDomainName(String domainName) { this.domainName = domainName; }

	@Override public String toString() { return userName + "@" + domainName; }
}
