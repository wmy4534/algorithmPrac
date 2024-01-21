import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for (int r = 0; r < N; r++) {
				int count = 0;
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1) {
						count++;
					} else if (count == K) {
						result++;
						count = 0;
					} else
						count = 0;
				}
				if (count == K)
					result++;
			}
			for (int c = 0; c < N; c++) {
				int count = 0;
				for (int r = 0; r < N; r++) {
					if (map[r][c] == 1) {
						count++;
					} else if (count == K) {
						result++;
						count = 0;
					} else
						count = 0;
				}
				if (count == K)
					result++;
			}
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb);
	}
}