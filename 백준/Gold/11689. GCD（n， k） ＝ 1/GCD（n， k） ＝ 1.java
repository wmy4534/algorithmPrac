import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long copy = n;
		for (long p = 2; p * p <= n; p++) {
			if (copy % p == 0) {
				n /= p;
				n *= (p - 1);
				while (copy % p == 0) {
					copy /= p;
				}
			}
		}
		if (copy > 1) {
			n /= copy;
			n *= (copy - 1);
		}

		System.out.println(n);
		br.close();
	}
}
