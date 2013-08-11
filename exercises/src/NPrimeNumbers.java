/*
 * First n prime numbers.
 */

public class NPrimeNumbers {

	public static void main(String args[]) {
		int number = Integer.valueOf(args[0]);
		for(int i=2;i<=number;i++) {
			if(isPrime(i)) {
				System.out.format("%d%s",i," ");
			}
		}
	}

	private static boolean isPrime(int number) {
		boolean prime = true;
		int limit = (int)Math.sqrt(number);
		
		for(int i=2; i<=limit; i++) {
			if(number%i==0) {
				prime = false;
				break;
			}
		}
		return prime;
	}
}
