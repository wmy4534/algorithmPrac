import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[][] map;
	static List<Integer> teachers;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean answer = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		teachers = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = st.nextToken().charAt(0);
				if (map[r][c] == 'T') {
					teachers.add(r * N + c);
				}
			}
		}
		int installed = 0;
		setUpBlock(installed, 0);
		String result = answer ? "YES" : "NO";
		System.out.println(result);
	}

	private static void setUpBlock(int installed, int num) {
		if (answer) {
			return;
		}
		if (installed >= 3) {
			if (canBlock()) {
				answer = true;
			}
			return;
		}
		for (int n = num; n < N * N; n++) {
			int r = n / N;
			int c = n % N;
			if (map[r][c] == 'X') {
				map[r][c] = 'O';
				setUpBlock(installed + 1, r * N + c + 1);
				map[r][c] = 'X';
			}
		}
	}

	private static boolean canBlock() {
		for (int teacher : teachers) {
			int r = teacher / N;
			int c = teacher % N;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc] == 'S') {
						return false;
					} else if (map[nr][nc] == 'O') {
						break;
					} else if (map[nr][nc] == 'T') {
						break;
					}
					nr += dr[i];
					nc += dc[i];
				}
			}
		}
		return true;
	}
}