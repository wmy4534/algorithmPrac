import java.util.Scanner;

public class Main {
	static int min;
	static Integer[] memo = new Integer[100001];
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		for (int i = 0; i <= N; i++) {
			memo[i] = N - i;
		}
		int max = Math.min(K + 1, 100000);
		for (int i = N + 1; i <= max; i++) {
			if (i % 2 == 0) {
				memo[i] = Math.min(memo[i - 1] + 1, memo[i / 2] + 1);
			} else {
				memo[i] = memo[i - 1] + 1;
			}
			if (memo[i]+1 < memo[i-1])
				memo[i-1] = memo[i]+1;
		}
		System.out.println(memo[K]);
	}
}