import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Integer[][] map;
	static Integer[][] shortcut;
	static int height;
	static int width;
	static Queue<Integer> queueR = new LinkedList<>();
	static Queue<Integer> queueC = new LinkedList<>();
	static Queue<Integer> tmpR = new LinkedList<>();
	static Queue<Integer> tmpC = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new Integer[height][width];
		shortcut = new Integer[height][width];
		int sr = 0; // 목표 r
		int sc = 0; // 목표 c
		for (int r = 0; r < height; r++) { // 지도 완성
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < width; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 2) {
					shortcut[r][c] = 0;
					sr = r;
					sc = c;
				}
			}
		}
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				if (map[r][c] == 0) {
					shortcut[r][c] = 0;
				}
			}
		}
		writeShortcut(sr, sc, 0);
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				if (shortcut[r][c] == null)
					shortcut[r][c] = -1;
				sb.append(shortcut[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

	private static void writeShortcut(int sr, int sc, int count) {
		tmpR.add(sr);
		tmpC.add(sc);
		while (tmpR.size() > 0) {
			while (tmpR.size() > 0) {
				queueR.add(tmpR.poll());
				queueC.add(tmpC.poll());
			}
			while (queueR.size() > 0) {
				sr = queueR.poll();
				sc = queueC.poll();
				for (int i = 0; i < 4; i++) {
					int nr = sr + dr[i];
					int nc = sc + dc[i];
					if (nr >= 0 && nr < height && nc >= 0 && nc < width) {
						if (map[nr][nc] == 0) {
//							if (shortcut[nr][nc] == null) {
								shortcut[nr][nc] = 0;
//								tmpR.add(nr);
//								tmpC.add(nc);
//							}
//							shortcut[nr][nr] = 0;
//							tmpR.add(nr);
//							tmpC.add(nc);
						} else {
							if (shortcut[nr][nc] == null) {
								shortcut[nr][nc] = count + 1;
								tmpR.add(nr);
								tmpC.add(nc);
							}
						}

					}
				}
			}
			count++;
		}
	}
}