package info.jab.recursion.concurrent;


public class PrimeNumberUtil {

	public static boolean isPrime(int num) {
		if (num == 2 || num == 3) {
			return true;
		}
		if (num % 2 == 0 || num % 3 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
