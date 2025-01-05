import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i][1] = Integer.parseInt(st.nextToken());
			max += arr[i][1];
		}
		br.close();
		
		int[] dp = new int[max + 1];
		for (int i = 0; i < N; i++) {
			int[] tmp = arr[i];
			for (int j = max; j >= tmp[1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - tmp[1]] + tmp[0]);
			}
		}
		for (int i = 0; i <= max; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				return;
			}
		}
	}
}
