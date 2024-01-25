import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][] map = new int[102][102];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			getColored(map, x, y);
		}
		int round = 0;
		for (int r = 1; r < 101; r++) {
			for (int c = 1; c < 101; c++) {
				if (map[r][c] == 1) {
					int count = 0;
					if (map[r + 1][c] == 1)
						count++;
					if (map[r][c + 1] == 1)
						count++;
					if (map[r - 1][c] == 1)
						count++;
					if (map[r][c - 1] == 1)
						count++;
					if (count == 3)
						round++;
					if (count == 2)
						round += 2;
				}
			}

		}
		System.out.println(round);
	}

	public static void getColored(int[][] map, int x, int y) {
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				map[x + i][y + j] = 1;
			}
		}
	}
}