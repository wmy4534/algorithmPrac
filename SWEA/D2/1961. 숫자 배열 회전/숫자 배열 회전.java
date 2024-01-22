import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= tc; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] numArr = new int[n][n];
			for (int r = 0; r < n; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					numArr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] copiedArr1 = new int[n][n];
			int[][] copiedArr2 = new int[n][n];
			int[][] copiedArr3 = new int[n][n];

			for (int c = 0; c < n; c++) {
				for (int r = n - 1; r >= 0; r--) {
					int nr = c;
					int nc = n - 1 - r;
					copiedArr1[nr][nc] = numArr[r][c];
				}
			}
			for (int c = 0; c < n; c++) {
				for (int r = n - 1; r >= 0; r--) {
					int nr = c;
					int nc = n - 1 - r;
					copiedArr2[nr][nc] = copiedArr1[r][c];
				}
			}
			for (int c = 0; c < n; c++) {
				for (int r = n - 1; r >= 0; r--) {
					int nr = c;
					int nc = n - 1 - r;
					copiedArr3[nr][nc] = copiedArr2[r][c];
				}
			}
			sb.append("#" + i + "\n");
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					sb.append(copiedArr1[r][c]);
				}
				sb.append(" ");
				for (int c = 0; c < n; c++) {
					sb.append(copiedArr2[r][c]);
				}
				sb.append(" ");
				for (int c = 0; c < n; c++) {
					sb.append(copiedArr3[r][c]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}