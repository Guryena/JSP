package servletEx02.lotto;

import java.util.Arrays;
import java.util.Random;

public class Lotto{
	private int lotto[] = new int[6];
	
	public Lotto() {
		getLotto();
	}
	
	private void getLotto() {
		Random num = new Random();
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = num.nextInt(44)+1;
			for (int j = 0; j <i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
				}
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(lotto);
	}
	
	
	
}
