import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			int size = Integer.parseInt(br.readLine());
			int[][] map = new int[size][size];
			for (int r = 0; r < size; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < size; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for (int c = 0; c < size; c++) {
				int nCount = 0;
				int sCount = 0;
				for (int r = 0; r < size; r++) {
					if (map[r][c] == 1) {
						nCount++;
						sCount = 0;
					} else if(map[r][c] == 2) {
						sCount++;
						if (nCount >= 1) {
							result++;
							nCount = 0;
						}
					}
				}
			}
			sb.append("#"+i+" "+result+"\n");
		}
		System.out.println(sb);
	}
}