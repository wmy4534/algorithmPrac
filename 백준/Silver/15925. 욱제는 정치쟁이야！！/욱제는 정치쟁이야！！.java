import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int HALF = N / 2;
		boolean isUse = st.nextToken().equals("1");
		boolean[][] map = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = st.nextToken().equals("1");
			}
		}
		
		int[] rows = new int[N];
		int[] columns = new int[N];
		for (int r = 0; r < N; r++) {
			int cnt = 0;
			for (int c = 0; c < N; c++) {
				if (map[r][c] == isUse)
					cnt++;
			}
			rows[r] = cnt;
		}
		
		for (int c = 0; c < N; c++) {
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				if (map[r][c] == isUse)
					cnt++;
			}
			columns[c] = cnt;
		}
		
		boolean condition = true;
		while (condition) {
			condition = false;
			for (int r = 0; r < N; r++) {
				int row = rows[r];
				if (row > HALF && row < N) {
					condition = true;
					rows[r] = N;
					for (int c = 0; c < N; c++) {
						if (map[r][c] != isUse) {
							map[r][c] = isUse;
							columns[c]++;
						}
					}
				}
			}
			
			for (int c = 0; c < N; c++) {
				int column = columns[c];
				if (column > HALF && column < N) {
					condition = true;
					columns[c] = N;
					for (int r = 0; r < N; r++) {
						if (map[r][c] != isUse) {
							map[r][c] = isUse;
							rows[r]++;
						}
					}
				}
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] != isUse) {
					System.out.println(0);
					return;
				}
			}
		}
		System.out.println(1);
	}
}
