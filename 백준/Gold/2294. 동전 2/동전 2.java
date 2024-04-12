import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int coin = sc.nextInt(); // 동전의 가치
			if (coin <= k) {
				set.add(coin);
			}
		}
		Integer[] coins = set.toArray(new Integer[0]);
		int[] dp = new int[k+1];
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];
			for (int j = 1; j <= k; j++) {
				if (j - coin >= 0) {
					dp[j] = Math.min(dp[j-coin]+1, dp[j]);
				}
			}
		}
		if (dp[k] >= 100001)
			dp[k] = -1;
		System.out.println(dp[k]);
	}
}