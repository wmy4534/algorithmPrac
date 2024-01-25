import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][] map = new int[5][5];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int r = 0; r < 5; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 5; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		Loop:
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				searchNum(map, num);
				count++;
				if (count >= 12) {
					int bingoNum = checkBingo(map);
					if(bingoNum >= 3) {
						System.out.println(count);
						break Loop;
					}
				}
			}
		}
	}

	private static void searchNum(int[][] map, int num) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == num) {
					map[i][j] = 0;
					return;
				}
			}
		}
	}

	private static int checkBingo(int[][] map) {
		int lDiagonal = 0;
		int rDiagonal = 0;
		int totalBingo = 0;
		for (int i = 0; i < map.length; i++) {
			int countR = 0;
			int countC = 0;
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 0) {
					countR++;
					if (countR == 5)
						totalBingo++;
				}
				if (map[j][i] == 0) {
					countC++;
					if (countC == 5)
						totalBingo++;
				}
				if (map[i][j] == 0 && i == j) {
					lDiagonal++;
					if (lDiagonal == 5)
						totalBingo++;
				}
				if (map[i][j] == 0 && i + j == map.length - 1) {
					rDiagonal++;
					if (rDiagonal == 5)
						totalBingo++;
				}
			}
		}
		return totalBingo;
	}

}