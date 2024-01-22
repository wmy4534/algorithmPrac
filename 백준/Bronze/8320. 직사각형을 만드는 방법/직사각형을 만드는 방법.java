import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		for (int i = 1; i < n; i++) {
			if (i * i > n) {
				max = i;
			}
		}
		int sum = n;
		for (int i = 2; i < max; i++) {
			for (int j = i; i * j <= n; j++) {
				sum++;
			}
		}
		System.out.println(sum);
	}
}