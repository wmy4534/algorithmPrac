import java.util.*;
import java.io.*;

public class Main {

	static int[] countArr;
	static int N, M, K;
	static long max;
	static int[] maxArr = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 최대값
		M = Integer.parseInt(st.nextToken()); // 참여하는 인원
		K = Integer.parseInt(st.nextToken()); // 추첨 횟수
		max = 0L;
		countArr = new int[N + 1];
		int[][] arr = new int[M - 1][3];
		for (int i = 0; i < M - 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int num = Integer.parseInt(st.nextToken());
				countArr[num]++;
				arr[i][j] = num;
			}
		}
		int total = M * 3;
		for (int a = 1; a <= N; a++) {
			countArr[a]++;
			for (int b = a + 1; b <= N; b++) {
				countArr[b]++;
				for (int c = b + 1; c <= N; c++) {
					countArr[c]++;
					check(a, b, c);
					countArr[c]--;
				}
				countArr[b]--;
			}
			countArr[a]--;
		}
		StringBuilder sb = new StringBuilder();
		long left = max;
		long right = (long) Math.pow(total, K + 1);
		long gcd = Euclidean(left, right);
		sb.append(left / gcd).append(" ").append(right / gcd).append("\n");
		for (int i = 0; i < 3; i++) {
			sb.append(maxArr[i]).append(" ");
		}
		System.out.println(sb);
	}

	private static long Euclidean(long left, long right) {
		if (right == 0) {
			return left;
		}
		return Euclidean(right, left % right);
	}

	private static void check(int a, int b, int c) {
		// 2개가 포함되어 있지 않고, 하나만 포함되어 있어야함
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			if (i == a || i == b || i == c) {
				continue;
			}
			sum += countArr[i];
		}
		long totalCase = (long) Math.pow(sum, K);
		totalCase *= (countArr[a] + countArr[b] + countArr[c]);
		if (totalCase > max) {
			max = totalCase;
			maxArr[0] = a;
			maxArr[1] = b;
			maxArr[2] = c;
		}
	}

}