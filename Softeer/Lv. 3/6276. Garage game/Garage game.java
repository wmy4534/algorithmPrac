import java.io.*;
import java.util.*;

// 필요한 기능은 bfs, drop, box size
// 색상 번호는 1부터 10억까지, N은 15까지
public class Main {
	static int N;
	static int height;
	static int gn; // garage N
	static int answer = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		height = N * 3;
		gn = N * 2;
		int[][] map = new int[height][N];
		for (int r = 0; r < height; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		Set<Integer> set = new HashSet<>();
		for (int c = 0; c < N; c++) {
			set.add(c);
		}
		game(1, 0, map, set);

		System.out.println(answer);
	}

	private static void game(int stage, int score, int[][] map, Set<Integer> set) {
		if (stage > 3) {
			answer = Math.max(score, answer);
			return;
		}
		int[][] stageMap = new int[height][N];
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < N; c++) {
				stageMap[r][c] = map[r][c];
			}
		}
		if (stage > 1) {
			drop(stageMap, set);
		}

		boolean[][] visited = new boolean[height][N];
		for (int c = 0; c < N; c++) {
			for (int r = gn; r < height; r++) {
				if (!visited[r][c] && stageMap[r][c] != 0) {
					visited[r][c] = true;

					Set<Integer> set2 = new HashSet<>();
					List<int[]> list = new ArrayList<>();
					Queue<int[]> queue = new LinkedList<>();
					int[] start = new int[] { r, c };
					int color = stageMap[r][c];
					set2.add(c);
					queue.offer(start);
					stageMap[r][c] = 0;
					list.add(new int[] { r, c, color });

					int num = 1;
					int maxR = r;
					int minR = r;
					int maxC = c;
					int minC = c;
					// bfs
					while (!queue.isEmpty()) {
						int[] tmp = queue.poll();
						for (int i = 0; i < 4; i++) {
							int nr = tmp[0] + dr[i];
							int nc = tmp[1] + dc[i];
							if (nr >= gn && nr < height && nc >= 0 && nc < N && !visited[nr][nc]
									&& stageMap[nr][nc] == color) {
								visited[nr][nc] = true;
								stageMap[nr][nc] = 0;
								int[] visit = new int[] { nr, nc };
								set2.add(nc);
								queue.offer(visit);
								num++;
								maxR = Math.max(maxR, nr);
								maxC = Math.max(maxC, nc);
								minR = Math.min(minR, nr);
								minC = Math.min(minC, nc);
								list.add(new int[] { nr, nc, color });
							}
						}
					}
					int boxArea = (maxR - minR + 1) * (maxC - minC + 1);
					game(stage + 1, score + boxArea + num, stageMap, set2);
					for (int[] tmp : list) {
						stageMap[tmp[0]][tmp[1]] = tmp[2];
					}
				}
			}
		}
	}

	private static void drop(int[][] stageMap, Set<Integer> set) {
		for (int c : set) {
			int rIdx = height-1;
			for (int r = height - 1; r >= 0; r--) {
				if (stageMap[r][c] != 0) {
					stageMap[rIdx--][c] = stageMap[r][c];
				}
			}
		}
	}
}
