package random.model;

import java.util.Random;

public class CoinService implements RandomService {

	double chanceOfHead;

	public CoinService() {
	}

	public CoinService(Double chanceOfHead) {
		if (chanceOfHead <= 1.0 && chanceOfHead >= 0.0) {
			this.chanceOfHead = chanceOfHead;
		} else {
			this.chanceOfHead = 0.5;
		}
	}

	public void setChance(Double chance) {
		if (chance <= 1.0 && chance >= 0.0) {
			chanceOfHead = chance;
		} else {
			chanceOfHead = 0.5;
		}
	}

	@Override
	public String getStringValue() {
		// random 0-1 and return as string "tail" or "head"
		Random getValueForCoin = new Random();
		String headOrtail = (getValueForCoin.nextInt(10) + 1 ) >= chanceOfHead * 10 ? "tail" : "head";
		return headOrtail;
	}
	
	public Double getChance(){
		return chanceOfHead;
	}

}
