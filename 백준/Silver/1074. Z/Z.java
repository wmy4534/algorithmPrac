import java.util.Scanner;

public class Main {
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		findNum(N, r, c);
		System.out.println(count);
	}

	private static void findNum(int N, int r, int c) {
		if (N < 1)
			return;
		int num = (int) Math.pow(2, N);
		if (num / 2 <= r && num / 2 <= c) { // 4사분면
			count += num * num / 4 * 3;
			findNum(N - 1, r - num / 2, c - num / 2);
		} else if (num / 2 <= r) { // 3사분면
			count += num * num / 4 * 2;
			findNum(N - 1, r - num / 2, c);
		} else if (r < num / 2 && num / 2 <= c) { // 2사분면
			count += num * num / 4;
			findNum(N - 1, r, c - num / 2);
		} else { // 1사분면
			findNum(N - 1, r, c);
		}
	}
}