import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 0, 1, 1 }; // 가로일 때
	static int[] dc = { 1, 1, 0 }; // 세로일 때

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][][] map = new int[n][n][3]; // 0은 가로, 1은 대각선, 2는 세로
		boolean[][] booleanMap = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int block = Integer.parseInt(st.nextToken());
				if (block == 0) {
					booleanMap[i][j] = true;
				}
			}
		}
		map[0][1][0] = 1;
		for (int r = 0; r < n; r++) {
			for (int c = 1; c < n; c++) {
				if (!booleanMap[r][c])
					continue;
				for (int i = 0; i < 3; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < n && nc < n && booleanMap[nr][nc]) {
						if (i == 1) {
							if (booleanMap[nr][c] && booleanMap[r][nc]) {
								map[nr][nc][i] += map[r][c][0] + map[r][c][1] + map[r][c][2];
							}
						} else if (i == 0) {
							map[nr][nc][i] += map[r][c][0] + map[r][c][1];
						} else {
							map[nr][nc][i] += map[r][c][1] + map[r][c][2];
						}
					}
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 3; i++) {
			result += map[n - 1][n - 1][i];
		}
		System.out.println(result);
	}
}