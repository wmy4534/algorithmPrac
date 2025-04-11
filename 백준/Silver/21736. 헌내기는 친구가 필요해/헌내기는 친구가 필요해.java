import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Point start = new Point();
		char[][] map = new char[N][M];
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c);
				if (map[r][c] == 'I') {
					start.x = c;
					start.y = r;
				}
			}
		}
		
		int cnt = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { start.y, start.x } );
		map[start.y][start.x] = 'X'; 
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int sr = tmp[0];
			int sc = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = sr + dr[i];
				int nc = sc + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 'X') {
					if (map[nr][nc] == 'P') {
						cnt++;
					}
					queue.offer(new int[] { nr, nc });
					map[nr][nc] = 'X';
				}
			}
		}
		System.out.println(cnt == 0 ? "TT" : cnt);
		
	}
}
