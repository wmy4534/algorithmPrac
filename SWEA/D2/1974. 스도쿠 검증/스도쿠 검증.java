import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= tc; i++) {
			int[][] sudoku = new int[9][9];
			for (int r = 0; r < 9; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 9; c++) {
					sudoku[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 1;
			Loop1: for (int r = 0; r < 9; r++) {
				int[] checkArr1 = new int[9];
				for (int c = 0; c < 9; c++) {
					checkArr1[sudoku[r][c] - 1]++;
					if (checkArr1[sudoku[r][c] - 1] > 1) {
						result = 0;
						break Loop1;
					}
				}
			}
			if (result == 1) {
				Loop2: for (int c = 0; c < 9; c++) {
					int[] checkArr2 = new int[9];
					for (int r = 0; r < 9; r++) {
						checkArr2[sudoku[r][c] - 1]++;
						if (checkArr2[sudoku[r][c] - 1] > 1) {
							result = 0;
							break Loop2;
						}
					}
				}
			}
			int cIncrease = 0;
			int rIncrease = 0;
			if (result == 1) {
				int[] checkArr3 = new int[9];
				Loop3: for (int r = 3 * rIncrease; r < Math.min(9, (rIncrease + 1) * 3); r++) {
					for (int c = 3 * cIncrease; c < Math.min(9, (cIncrease + 1) * 3); c++) {
						checkArr3[sudoku[r][c] - 1]++;
						if (checkArr3[sudoku[r][c] - 1] > 1) {
							result = 0;
							break Loop3;
						}
						if (r%3==2 && c==8) {
							cIncrease = 0;
							rIncrease++;
						}
					}
					if (r % 3 == 2) {
						cIncrease++;
					}
				}
			}
			sb.append("#" + i + " " + result + "\n");
		}
		System.out.print(sb);
	}
}