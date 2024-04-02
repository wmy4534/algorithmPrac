import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static Boolean[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] fromStartMap; // 시작점에서 출발하여 최단 거리
	static int[][] fromGoalMap; // 도착점에서 출발하여 최단 거리

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Boolean[N][M];
		fromStartMap = new int[N][M];
		fromGoalMap = new int[N][M];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = (str.charAt(c) == '0');
			}
		}

		int[] start = { 0, 0 };
		bfs(start, fromStartMap);
		int[] goal = { N - 1, M - 1 };
		bfs(goal, fromGoalMap);
		int minCnt = fromStartMap[N - 1][M - 1] == 0 ? Integer.MAX_VALUE : fromStartMap[N - 1][M - 1]; // 만약에 장애물을 거치지
																										// 않고 도달할 수 있다면

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!map[r][c]) {
					int minStart = 987654321; // 시작점으로부터 출발
					int minGoal = 987654321; // 도착점으로부터 출발
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];

						if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
							if (fromStartMap[nr][nc] != 0) {
								minStart = Math.min(minStart, fromStartMap[nr][nc]);
							}
							if (fromGoalMap[nr][nc] != 0) {
								minGoal = Math.min(minGoal, fromGoalMap[nr][nc]);
							}
						}
					}
					if (minStart == 987654321 || minGoal == 987654321)
						continue;
					if (minCnt > minStart + minGoal + 1)
						minCnt = minStart + minGoal + 1;
				}
			}
		}
		if (minCnt >= 987654321) {
			minCnt = -1;
		}
		System.out.println(minCnt);
	}

	private static void bfs(int[] start, int[][] cntMap) {
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		visited[start[0]][start[1]] = true;
		int time = 0;
		dq.offerLast(start);
		while (!dq.isEmpty()) {
			int size = dq.size();
			time++;
			for (int i = 0; i < size; i++) {
				int[] s = dq.pollFirst();
				cntMap[s[0]][s[1]] = time;
				for (int j = 0; j < 4; j++) {
					int nr = s[0] + dr[j];
					int nc = s[1] + dc[j];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc]) {
						visited[nr][nc] = true;
						dq.offerLast(new int[] { nr, nc });
					}
				}
			}
		}
	}

}