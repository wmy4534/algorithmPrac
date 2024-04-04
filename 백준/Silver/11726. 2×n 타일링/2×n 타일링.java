import java.util.Scanner;

public class Main {
	static int[] memo = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		memo[1] = 1;
		memo[2] = 2;
		
		int result = fibo(n);
		System.out.println(result);
	}
	private static int fibo(int n) {
		if (n <= 2) {
			return memo[n];
		}
		if (memo[n] == 0) {
			memo[n] = fibo(n-1) + fibo(n-2);
			memo[n] %= 10007;
		}
		return memo[n];
	}
}