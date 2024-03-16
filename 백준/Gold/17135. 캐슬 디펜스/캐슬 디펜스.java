import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int attackRange;
	static boolean[][] map; // 적이 있으면 true 없으면 false
	static int[] archers;
	static int[] dr = { 0, -1, 0 }; // 좌 상 우
	static int[] dc = { -1, 0, 1 }; // 좌 상 우
	static int[][] enemyLocation = new int[3][2];
	static int count;
	static int maxCount = 0;
	static boolean[][] cloneMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		attackRange = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = st.nextToken().equals("1");
			}
		}
		archers = new int[3]; // 궁수 위치
		for (int i = 0; i < M; i++) {
			archers[0] = i;
			for (int j = i + 1; j < M; j++) {
				archers[1] = j;
				for (int k = j + 1; k < M; k++) {
					archers[2] = k;
					attack();
				}
			}
		}
		System.out.println(maxCount);
	}

	private static void attack() {
		count = 0;
		arrClone(); // 복사 지도
		for (int repeat = 0; repeat < N; repeat++) {
			Integer[] arr = new Integer[2]; // r, c 좌표

			arr[0] = N - 1; // r 좌표
			for (int i = 0; i < 3; i++) {
				arr[1] = archers[i]; // c 좌표
				enemyLocation[i] = findEnemy(arr);
			}
			for (int i = 0; i < 3; i++) {
				if (enemyLocation[i] != null && cloneMap[enemyLocation[i][0]][enemyLocation[i][1]]) {
					cloneMap[enemyLocation[i][0]][enemyLocation[i][1]] = false;
					count++;
				}
			}
			move();
		}
		if (count > maxCount) {
			maxCount = count;
		}
	}

	private static void arrClone() {
		cloneMap = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				cloneMap[r][c] = map[r][c];
			}
		}
	}

	private static void move() {
		for (int c = 0; c < M; c++) {
			cloneMap[N - 1][c] = false;
		}
		for (int r = N - 2; r >= 0; r--) {
			for (int c = 0; c < M; c++) {
				if (cloneMap[r][c]) {
					cloneMap[r + 1][c] = true;
					cloneMap[r][c] = false;
				}
			}
		}

	}

	private static int[] findEnemy(Integer[] arr) {
		boolean[][] visited = new boolean[N][M];
		if (cloneMap[arr[0]][arr[1]]) {
			return new int[] { arr[0], arr[1] };
		}
		visited[arr[0]][arr[1]] = true;
		Queue<Integer[]> queue = new LinkedList<>();
		queue.offer(arr);
		int range = 1;
		while (!queue.isEmpty()) {
			if (range >= attackRange) {
				break;
			}
			int size = queue.size();
			range++;
			for (int i = 0; i < size; i++) {
				Integer[] tmp = queue.poll();
				int r = tmp[0];
				int c = tmp[1];
				for (int idx = 0; idx < 3; idx++) {
					int nr = r + dr[idx];
					int nc = c + dc[idx];
					if (nr >= 0 && nc >= 0 && nc < M && !visited[nr][nc]) {
						if (cloneMap[nr][nc]) {
							return new int[] { nr, nc };
						} else {
							queue.offer(new Integer[] { nr, nc });
						}
					}
				}
			}
		}
		return null;
	}
}