import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long answer = 0L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < n - 1; i++) {
				long num1 = arr[i];
				for (int j = i + 1; j < n; j++) {
					long num2 = arr[j];
					answer += gcd(num1, num2);
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static long gcd(long num1, long num2) {
		if (num1 % num2 == 0L)
			return num2;
		return gcd(num2, num1 % num2);
	}
}
