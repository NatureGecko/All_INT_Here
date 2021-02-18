package random.model;

import java.util.Random;

public class DiceService implements RandomService {
	@Override
	public String getStringValue() {
		// random 1-6 and return as a string
		Random getRandomNumber = new Random();
		String randomAndGet = "" + (getRandomNumber.nextInt(6) + 1);
		return randomAndGet;
	}
}
