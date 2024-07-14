import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Boolean[] primes = new Boolean[N+1];
		for (int i = 2; i <= N; i++) {
			int multi = 2;
			if (primes[i] == null) {
				primes[i] = true;
				int prime = i;
				while (true) {
					int num = prime * multi++;
					if (num > N)
						break;
					primes[num] = false;
				}
			}
		}
		int sum = 0;
		int answer = 0;
		int rpoint = 2;
		for (int lpoint = 2; lpoint <= N; lpoint++) {
			if (primes[lpoint]) {
				sum += lpoint;
				if (sum == N) {
					answer++;
				} else if (sum < N) {
					continue;
				} else { // sum이 더 크면
					while (sum > N && rpoint <= N) {
						if (primes[rpoint]) {
							sum -= rpoint;
						}
						rpoint++;
					}
					if (sum == N)
						answer++;
				}
			}
		}
		System.out.println(answer);
	}
}