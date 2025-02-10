import java.util.*;
import java.io.*;

public class Main {

	static int[][] board = new int[6][7];
	static StringTokenizer st;
	static int[] lowest = new int[7];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 7; i++) {
			lowest[i] = 5;
		}
		for (int i = 1; i <= 21; i++) {
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken()) - 1; // 상근이 열
			int ji = Integer.parseInt(st.nextToken()) - 1; // 정인이 열
			board[lowest[si]][si] = i * 2 - 1;
			lowest[si]--;
			board[lowest[ji]][ji] = i * 2;
			lowest[ji]--;
		}

		int max = 43;
		int[] dr = { 1, 0, 1, 1 }; // 아래, 오른쪽, 대각선 오른쪽 아, 대각선 왼쪽 아
		int[] dc = { 0, 1, 1, -1 };
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 7; c++) {
				boolean bool = (board[r][c] % 2 == 0);
				for (int i = 0; i < 4; i++) {
					List<Integer> list = new ArrayList<>();
					for (int j = 0; j < 4; j++) {
						int nr = r + dr[i] * j;
						int nc = c + dc[i] * j;
						if (nr >= 0 && nr < 6 && nc >= 0 && nc < 7 && (board[nr][nc] % 2 == 0) == bool) {
							list.add(board[nr][nc]);
						} else {
							break;
						}
					}
					if (list.size() >= 4) {
						Collections.sort(list);
						if (max > list.get(3)) {
							max = list.get(3);
						}
					}
				}
			}
		}
		if (max > 42) {
			System.out.println("ss");
		} else if (max % 2 == 0) {
			System.out.println("ji " + max / 2);
		} else {
			System.out.println("sk " + (max / 2 + 1));
		}
	}

}
