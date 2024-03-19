import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] baseball;
	static int maxScore = 0;
	static int score;
	static boolean[] field = new boolean[4];
	static Integer[] orderOfPlayer = new Integer[9];
	static Integer[] tmp = new Integer[8];
	static boolean[] players = new boolean[9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		baseball = new int[n][9];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				baseball[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		selectPlayer(0);
		System.out.println(maxScore);
	}

	private static void Play() {
		int order = 0;
		score = 0;
		for (int i = 0; i < n; i++) {
			field = new boolean[4]; // 1루 2루 3루
			int outCount = 0; // 아웃카운트
			while (outCount < 3) { // 아웃카운트가 3보다 작을 때
				switch (baseball[i][orderOfPlayer[order]]) { // 각 선수의 기대 타격
				case 0:
					outCount++;
					break;
				case 1:
					for (int p = 3; p >= 1; p--) {
						if (p + 1 >= 4 && field[p]) {
							field[p] = false;
							score++;
						} else if (field[p]) {
							field[p + 1] = true;
							field[p] = false;
						}
					}
					field[1] = true;
					break;
				case 2:
					for (int p = 3; p >= 1; p--) {
						if (p + 2 >= 4 && field[p]) {
							field[p] = false;
							score++;
						} else if (field[p]) {
							field[p + 2] = true;
							field[p] = false;
						}
					}
					field[2] = true;
					break;
				case 3:
					for (int p = 3; p >= 1; p--) {
						if (p + 3 >= 4 && field[p]) {
							field[p] = false;
							score++;
						} else if (field[p]) {
							field[p + 3] = true;
							field[p] = false;
						}
					}
					field[3] = true;
					break;
				case 4:
					for (int p = 1; p <= 3; p++) {
						if (field[p]) {
							field[p] = false;
							score++;
						}
					}
					score++;
					break;
				}
				order++;
				order %= 9;
			}
		}
		if (maxScore < score) {
			maxScore = score;
		}
	}

	private static void selectPlayer(int order) {
		if (tmp[7] != null) {
			for (int i = 0; i < 9; i++) {
				if (i < 3) {
					orderOfPlayer[i] = tmp[i];
				} else if (i == 3) {
					orderOfPlayer[i] = 0;
				} else {
					orderOfPlayer[i] = tmp[i-1];
				}
			}
			Play();
		}
		for (int i = 1; i < 9; i++) {
			if (!players[i]) { // i번 선수
				players[i] = true; // 선택
				tmp[order] = i;
				selectPlayer(order + 1);
				tmp[order] = null;
				players[i] = false; // 취소
			}
		}
	}
}