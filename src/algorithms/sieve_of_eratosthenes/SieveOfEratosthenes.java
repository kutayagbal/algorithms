package algorithms.sieve_of_eratosthenes;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		boolean[] prime = getPrimesListSmallerThan(300);
		for (int i = 0; i < prime.length; i++) {
			if (prime[i])
				System.out.print(i + ", ");
		}
	}

	public static boolean[] getPrimesListSmallerThan(int n) {
		boolean[] prime = new boolean[n+1];
		for (int i = 2; i <= n; i++) {
			prime[i] = true;
		}

		int sqrt = (int) Math.sqrt(prime.length);
		for (int i = 2; i <= sqrt; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= n; j += i) {
					prime[j] = false;
				}
			}
		}

		return prime;
	}

}
