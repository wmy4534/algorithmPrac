import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] map;
	static int[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new int[M][N];
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				visited[r][c] = -1; // 아직 방문하지 않은 곳
			}
		}

		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int path = dfs(0, 0);
		System.out.print(path);

	}

	private static int dfs(int r, int c) {
		if (r == M - 1 && c == N - 1) {
			return 1;
		}

		if (visited[r][c] != -1) {
			return visited[r][c];
		}

		visited[r][c] = 0;
		for (int idx = 0; idx < 4; idx++) { // 델타 배열 인덱스
			int nr = r + dr[idx];
			int nc = c + dc[idx];
			if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] < map[r][c]) {
				visited[r][c] += dfs(nr, nc);
			}
		}
		return visited[r][c];

	}
}