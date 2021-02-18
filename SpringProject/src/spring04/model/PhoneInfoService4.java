package spring04.model;

import org.springframework.beans.factory.annotation.Value;
import spring01.model.GenericInfoService;

public class PhoneInfoService4 implements GenericInfoService {
	
	private String phoneNumber;
	private int extension;
	
	// setter/method injection
	public PhoneInfoService4() { }
	@Value("02-470-9850") public void setThePhoneNumber(String num) { phoneNumber = num; }
	@Value("1111") public void setTheExtension(int ext) { extension = ext; }
	
	@Override public String getServiceName() { return "phone service"; }
	@Override public String toString() { return phoneNumber + " (" + extension + ")"; }
}
