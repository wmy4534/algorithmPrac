import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 동전 종류의 개수
        int k = sc.nextInt(); // 목표 금액
        int[] coins = new int[n]; // 동전의 가치를 저장할 배열
        int[] dp = new int[k + 1]; // 경우의 수를 저장할 배열

        // 동전의 가치 입력받기
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        dp[0] = 1; // 0원을 만들 수 있는 경우의 수는 1가지
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.print(dp[k]);
    }
}