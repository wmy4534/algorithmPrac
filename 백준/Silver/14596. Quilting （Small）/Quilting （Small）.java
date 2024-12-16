import java.io.*;
import java.util.*;

class Main {
	static int H, W;
	static int[][] map, leastMap;
	static int[] dc = new int[] { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		leastMap = new int[H][W];
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				leastMap[r][c] = Integer.MAX_VALUE;
			}
		}
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				map[r][c] -= Integer.parseInt(st.nextToken());
				map[r][c] *= map[r][c];
			}
		}
		for (int c = 0; c < W; c++) {
			leastMap[0][c] = map[0][c];
		}

		for (int c = 0; c < W; c++) {
			dp(0, c);
		}
		int answer = Integer.MAX_VALUE;
		for (int c = 0; c < W; c++) {
			answer = Math.min(leastMap[H - 1][c], answer);
		}
		System.out.println(answer);
	}

	private static void dp(int r, int c) {
		if (r + 1 == H)
			return;
		for (int i = 0; i < 3; i++) {
			int nc = c + dc[i];
			if (nc >= 0 && nc < W && leastMap[r + 1][nc] > leastMap[r][c] + map[r + 1][nc]) {
				leastMap[r + 1][nc] = leastMap[r][c] + map[r + 1][nc];
				dp(r + 1, nc);
			}
		}
	}
}