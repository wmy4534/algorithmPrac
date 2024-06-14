import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		boolean move = true;
		while (move) {
			int groupNum = 1;
			visited = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (visited[r][c] == 0) {
						bfs(r, c, groupNum);
						groupNum++;
					}
				}
			}
			if (groupNum > N * N)
				break;
			day++;
			int[] sums = new int[groupNum+1]; // 각 그룹별로 인구의 총합
			int[] count = new int[groupNum+1]; // 각 그룹별로 몇 개의 나라가 포함되어 있는 지
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					sums[visited[r][c]] += map[r][c];
					count[visited[r][c]]++;
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sums[visited[r][c]] / count[visited[r][c]];
				}
			}
		}
		System.out.println(day);
	}

	private static void bfs(int r, int c, int groupNum) {
		visited[r][c] = groupNum;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == 0 && Math.abs(map[nr][nc] - map[tmp[0]][tmp[1]]) >= L && Math.abs(map[nr][nc] - map[tmp[0]][tmp[1]]) <= R) {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = groupNum;
				}
			}
		}
		
	}
}