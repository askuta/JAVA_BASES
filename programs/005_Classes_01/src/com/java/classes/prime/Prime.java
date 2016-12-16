package com.java.classes.prime;

public class Prime {

	private final boolean[] primes;

	public Prime(int number) {
		primes = new boolean[number + 1];

		primes[0] = false;
		primes[1] = false;
		for (int index = 2; index < primes.length; index++) {
			primes[index] = true;
		}
	}

	public void printPrimes() {
		for (int index = 2; index < primes.length; index++) {
			if (primes[index]) {
				System.out.print(index + " ");

				for (int i = index; i < primes.length; i = i + index) {
					primes[i] = false;
				}
			}
		}
	}
}
