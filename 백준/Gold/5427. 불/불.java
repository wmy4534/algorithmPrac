import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		repeat: for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int[][] map = new int[R][C];
			Deque<int[]> fire = new ArrayDeque<>(); // 불의 위치를 담을 덱
			Deque<int[]> dq = new ArrayDeque<>(); // 현재 위치를 담을 덱
			for (int r = 0; r < R; r++) {
				String str = br.readLine();
				for (int c = 0; c < C; c++) {
					switch (str.charAt(c)) {
					case '#':
						map[r][c] = -1; // 벽은 -1로
						break;
					case '.':
						map[r][c] = 0; // 지나갈 수 있는 곳은 0으로
						break;
					case '@':
						map[r][c] = 0;
						dq.offerLast(new int[] { r, c });
						break;
					case '*':
						map[r][c] = -1; // 불난 곳은 -1로
						fire.offerLast(new int[] { r, c });
						break;
					}
				}
			}
			int time = 0;
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			int size = 0;
			int[] curLoc = dq.peekFirst();
			if (curLoc[0] == 0 || curLoc[0] == R - 1 || curLoc[1] == 0 || curLoc[1] == C - 1) {
				sb.append(1).append("\n"); // 밖으로 바로 탈출 가능
				continue repeat;
			}
			while (!dq.isEmpty()) {
				time++;
				size = fire.size(); // 불 먼저 확산
				for (int i = 0; i < size; i++) {
					int[] tmp = fire.pollFirst();
					for (int idx = 0; idx < 4; idx++) {
						int nr = tmp[0] + dr[idx];
						int nc = tmp[1] + dc[idx];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
							map[nr][nc] = -1;
							fire.offerLast(new int[] { nr, nc });
						}
					}
				}
				size = dq.size(); // 지훈이 이동
				for (int i = 0; i < size; i++) {
					int[] tmp = dq.pollFirst();
					for (int idx = 0; idx < 4; idx++) {
						int nr = tmp[0] + dr[idx];
						int nc = tmp[1] + dc[idx];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
							map[nr][nc] = time;
							if (nr == 0 || nr == R - 1 || nc == 0 || nc == C - 1) {
								sb.append(time + 1).append("\n"); // 밖으로 나가야하므로 한 번 더 움직여야 한다.
								continue repeat;
							}
							dq.offerLast(new int[] { nr, nc });
						}
					}
				}
			} // bfs
			sb.append("IMPOSSIBLE").append("\n");
		}
		System.out.println(sb);
	} // main
}