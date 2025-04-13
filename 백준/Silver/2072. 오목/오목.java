import java.util.*;
import java.io.*;

public class Main {

	static Boolean[][] map = new Boolean[21][21];
	static StringTokenizer st;
	static int[][] dr = { { -1, 1 }, { 0, 0 }, { -1, 1 }, { -1, 1 } };
	static int[][] dc = { { 0, 0 }, { -1, 1 }, { -1, 1 }, { 1, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 놓는 돌의 개수
		boolean isComplete = false;
		for (int i = 1; i <= N; i++) { // 홀수는 흑, 짝수는 백
			boolean isBlack = (i % 2 == 1);
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = isBlack; // 흑이면 true, 백이면 false
			isComplete = check(isBlack, r, c);
			if (isComplete) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
		return;
	}

	private static boolean check(boolean isBlack, int r, int c) {
		// map은 null로 감싸져있기 떄문에 경계 범위는 null로 조건을 걸면 된다
		// 상하, 좌우, 대각선 2개
		for (int i = 0; i < 4; i++) {
			int conti = 1;
			for (int j = 0; j < 2; j++) {
				int nr = r + dr[i][j];
				int nc = c + dc[i][j];
				while (map[nr][nc] != null && map[nr][nc] == isBlack) {
					conti++;
					nr += dr[i][j];
					nc += dc[i][j];
				}
			}
			if (conti == 5) {
				return true;
			}
		}
		return false;
	}
}
