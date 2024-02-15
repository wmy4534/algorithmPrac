import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = str.charAt(c) - '0';
				}
			}
			int curR = N / 2;
			int curC = 0;
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 1) {
					for (int j = 0; j < N / 2; j++) { // 홀수번 째로 대각선으로 수확
						sum += map[curR][curC];
						curR++;
						curC++;
					}
				} else {
					for (int j = 0; j < N / 2 - 1; j++) { // 짝수번째로 대각선 수확
						sum += map[curR][curC];
						curR--;
						curC--;
					}
				}
				sum += map[curR][curC];
				curR--;
			}
			sb.append("#"+t+" "+sum).append("\n");
		}
		System.out.print(sb);
	}
}