import java.util.*;
import java.io.*;

public class Main {

	static int N, M, answer;
	static char[][] map;
	static int[][] visited;
	static Map<Character, int[]> dir = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dir.put('U', new int[] { -1, 0 });
		dir.put('D', new int[] { 1, 0 });
		dir.put('L', new int[] { 0, -1 });
		dir.put('R', new int[] { 0, 1 });

		map = new char[N][M];
		visited = new int[N][M];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (visited[r][c] > 0)
					continue;
				count++;
				int nr = r;
				int nc = c;
				while (visited[nr][nc] == 0) {
					visited[nr][nc] = count;
					int[] tmp = dir.get(map[nr][nc]);
					nr += tmp[0];
					nc += tmp[1];
				}
				if (visited[nr][nc] != count) {
					continue;
				} else {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
