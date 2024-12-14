import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger num = new BigInteger(br.readLine());
		BigInteger two = BigInteger.TWO;
		Long n = Long.parseLong(num.divide(two).toString());
		if (n <= 0) {
			System.out.println(0);
			return;
		}
		BigInteger[] first = num.divideAndRemainder(two);
		int remain = Integer.parseInt(first[1].toString());
		if (remain == 1) {
			System.out.println(64);
			return;
		}
		int cnt = 1;
		while (n % 2 == 0 && n > 0) {
			n /= 2;
			cnt++;
		}
		System.out.println(64 - cnt);
	}
}
