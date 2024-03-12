import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		long B = sc.nextLong();
		arr = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				arr[r][c] = sc.nextInt() % 1000;
			}
		}
		int[][] result = findSquare(B);
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				sb.append(result[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static int[][] calTable(int[][] arr1, int[][] arr2) {
		int[][] result = new int[n][n];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				for (int k = 0; k < n; k++) {
					result[r][c] += arr1[r][k] * arr2[k][c];
				}
				result[r][c] %= 1000;
			}
			
		}
		return result;
	}

	private static int[][] findSquare(long B) {
		if (B == 1) {
			return arr;
		}
		int[][] tmp = findSquare(B / 2);
		int[][] squaredTmp = calTable(tmp, tmp);
		if (B % 2 == 0) {
			return squaredTmp;
		} else {
			return calTable(squaredTmp, arr);
		}
	}
}