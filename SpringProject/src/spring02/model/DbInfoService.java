package spring02.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import spring01.model.GenericInfoService;

@Component("dbServiceBean")
@Scope("prototype")
public class DbInfoService implements GenericInfoService {
	@Override
	public String getServiceName() { return "database service"; }
}
