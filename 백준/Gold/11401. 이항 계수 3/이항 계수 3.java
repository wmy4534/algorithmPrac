import java.util.Scanner;

public class Main {
	static final int mod = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long K = sc.nextInt();

		long result = 1L;
		for (long i = N; i > Math.max(N - K, K); i--) {
			result *= i;
			result %= mod;
		}
		long div = 1L;
		for (long i = 1; i <= Math.min(K, N - K); i++) {
			div *= i;
			div %= mod;
		}
		result *= pow(div, mod - 2) % mod;
		result %= mod;
		System.out.println(result);
	}

	private static long pow(long div, int i) {
		if (i <= 1)
			return div;
		long tmp = (pow(div, i / 2) % mod);
		if (i % 2 == 0) {
			return (tmp * tmp) % mod;
		} else {
			return ((tmp * tmp % mod) * (div % mod)) % mod;
		}
	}
}