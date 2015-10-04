
public class BegR1P1 {
	
	/*
	 * Print the first ten primes. Use the given method isPrime 
	 */
	
	public boolean printPrimes(){
		//Enter your code here.
		
		
		
		//Returns true if the number is a prime, false if not. Use isPrime.
		return false;
	}
	
	
	public boolean isPrime(int n) {
		int x = (int)Math.sqrt(n);
		for(int i = 2; i <= x; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
