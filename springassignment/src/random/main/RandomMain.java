package random.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import random.model.CoinService;
import random.model.RandomService;

public class RandomMain {
	
	private static String youRolled = " You rolled : ";
	private static String youToasted = " You get : ";
	private static String withAchanceOf = " With a chance of getting head of ";
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 1. diceBean - IoC
		RandomService diceBean = (RandomService) context.getBean("diceBean");
		System.out.println(youRolled + diceBean.getStringValue());
		
		// 2. fairCoinBean - DI constructor injection 0.5
		CoinService fairCoinBean = (CoinService) context.getBean("fairCoinBean");
		System.out.println(youToasted + fairCoinBean.getStringValue() + withAchanceOf + fairCoinBean.getChance());
		
		// 3. biasCoinBean - DI setter injection 0.1
		CoinService biasCoinBean = (CoinService) context.getBean("biasCoinBean");
		System.out.println(youToasted + biasCoinBean.getStringValue() + withAchanceOf + biasCoinBean.getChance());
		
		// 4. propertyCoinBean - DI setter injection read from property file
		CoinService propertyCoinBean = (CoinService) context.getBean("propertyCoinBean");
		System.out.println(youToasted + propertyCoinBean.getStringValue() + withAchanceOf + propertyCoinBean.getChance());
		
		
		context.close();
	}
}

/*
 * 1. diceBean - IoC 2. fairCoinBean - DI constructor injection 0.5 3.
 * biasCoinBean - DI setter injection 0.1 4. propertyCoinBean - DI setter
 * injection read from property file
 * 
 * - random01 - xml configuration: 1-4 - random03 - java class with component
 * scanning: 1 and one of 2,3,4
 */