import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		Integer[][] map = new Integer[R][C];
		List<int[]> swans = new ArrayList<>();
		Deque<int[]> dq = new ArrayDeque<>();
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				if (str.charAt(c) == '.') {
					map[r][c] = 0;
					dq.offerLast(new int[] {r, c});
				}
				else if (str.charAt(c) == 'L') {
					map[r][c] = 0;
					swans.add(new int[] {r, c});
					dq.offerLast(new int[] {r, c});
				}
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		while (!dq.isEmpty()) {
			int[] tmp = dq.pollFirst();
			int r = tmp[0];
			int c = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == null) {
					map[nr][nc] = map[r][c] + 1;
					dq.offerLast(new int[] {nr, nc});
				}
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return arr1[2] - arr2[2];
			}
		});
		pq.offer(new int[] {swans.get(0)[0], swans.get(0)[1], 0});
		
		boolean[][] visited = new boolean[R][C];
		visited[swans.get(0)[0]][swans.get(0)[1]] = true;
		
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int r = tmp[0];
			int c = tmp[1];
			if (r == swans.get(1)[0] && c == swans.get(1)[1]) {
				System.out.println(tmp[2]);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
					pq.offer(new int[] {nr, nc, Math.max(tmp[2], map[nr][nc])});
					visited[nr][nc] = true;
				}
			}
		}
	}
}