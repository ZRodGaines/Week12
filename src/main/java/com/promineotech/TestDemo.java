package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPostive2(int a, int b) throws IllegalArgumentException {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both Parameters must be positive!");
		}
	}
	
	//Returns boolean true if the sum of both int parameters == 5, if not throws exception
	public int theseMakeFive(int a, int b) throws IllegalArgumentException {
		if( a + b == 5) {//if the sum == 5...
			return 5;//return 5!
		} else {
			throw new IllegalArgumentException("These do not make five!");//... if sum does not == 5 then throw exception
		}
	}
	
	public int getRandomInt() {
		int ranInt = 0;
		Random random = new Random();
		ranInt = random.nextInt(10) + 1;
		return ranInt;
	}
	
	
	int randomNumberSquared(int ranInt) {
		int ranIntSquared = ranInt * ranInt;
		return ranIntSquared;
	}
}
