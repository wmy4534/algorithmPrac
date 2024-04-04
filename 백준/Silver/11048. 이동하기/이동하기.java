import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, 0, 1 };
	static int[] dc = { 0, 1, 1 };
	static int N;
	static int M;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int maxCnt = dfs(0, 0);
		System.out.println(maxCnt);

	}

	private static int dfs(int r, int c) {
		if (r == N-1 && c == M-1) {
			return map[r][c];
		}
		
		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if (dp[nr][nc] < 0 && dp[r][c] < 0) { // 현재 위치는 첫 방문, 한 번도 방문하지 않았던 다음
					dp[r][c] = map[r][c] + dfs(nr, nc);
				} else if (dp[nr][nc] < 0) { // 현재 위치는 방문했지만, 다음 장소는 방문하지 않은 경우
					dp[r][c] = Math.max(map[r][c] + dfs(nr, nc), dp[r][c]);
				} else if (dp[r][c] < 0) { // 현재 위치는 첫 방문이지만, 다음 장소는 방문했던 경우
					dp[r][c] = map[r][c] + dp[nr][nc];
				}
			}
		}
		
		return dp[r][c];
	}

}