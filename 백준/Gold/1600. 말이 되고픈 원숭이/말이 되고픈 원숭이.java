import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[][] monkeyMove = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] horseMove = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 },
			{ 2, 1 } };
	static boolean[][] map;
	static int[][][] visited; // 방문한 횟수

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()); // 말의 움직임을 따라할 수 있는 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[h][w];
		boolean[][][] visited = new boolean[h][w][K + 1];
		for (int r = 0; r < h; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < w; c++) {
				map[r][c] = st.nextToken().equals("0");
			}
		}

		Deque<int[]> dq = new ArrayDeque<>();
		dq.offerLast(new int[] { 0, 0 });
		visited[0][0][0] = true;
		int cnt = 0;
		int result = -1;
		Bfs: while (!dq.isEmpty()) {
			int size = dq.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				int[] start = dq.pollFirst();
				int currR = start[0];
				int currC = start[1];
				if (currR == h - 1 && currC == w - 1) {
					result = cnt - 1;

					break Bfs;
				}
				for (int hIdx = 0; hIdx < 8; hIdx++) { // 말의 움직임 좌표
					int nr = currR + horseMove[hIdx][0];
					int nc = currC + horseMove[hIdx][1];
					if (nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc]) {
						for (int j = 0; j < K; j++) {
							if (visited[currR][currC][j] && !visited[nr][nc][j + 1]) {
								dq.offerLast(new int[] { nr, nc });
								visited[nr][nc][j + 1] = true;
							}
						}
					}
				}

				for (int mIdx = 0; mIdx < 4; mIdx++) { // 원숭이의 움직임 좌표
					int nr = currR + monkeyMove[mIdx][0];
					int nc = currC + monkeyMove[mIdx][1];
					if (nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc]) {
						for (int j = 0; j <= K; j++) {
							if (visited[currR][currC][j] && !visited[nr][nc][j]) {
								dq.offerLast(new int[] { nr, nc });
								visited[nr][nc][j] = true;
							}
						}
					}
				}
			}
		}
		System.out.println(result);

	}
}