import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = Character.getNumericValue(str.charAt(c));
			}
		}
		Map<Integer, Integer> area = new HashMap<>();
		int idx = -1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					int count = 0;
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[] { r, c });
					map[r][c] = idx;
					while (!queue.isEmpty()) {
						int[] tmp = queue.poll();
						count++;
						for (int i = 0; i < 4; i++) {
							int nr = tmp[0] + dr[i];
							int nc = tmp[1] + dc[i];
							if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
								map[nr][nc] = idx;
								queue.offer(new int[] {nr, nc});
							}
						}
					}
					area.put(idx--, count);
				}
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					Set<Integer> set = new HashSet<>();
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] < 0) {
							set.add(map[nr][nc]);
						}
					}
					int num = 1;
					for (Integer i : set) {
						num += area.get(i);
					}
					num %= 10;
					sb.append(num);
				} else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
