package net.darkhax.moreswords.lib;

import java.util.Random;

public class RandomUtils extends Random {

	public int nextIntII(int min, int max) {
		
		return nextInt(max - min + 1) + min;
	}
}
