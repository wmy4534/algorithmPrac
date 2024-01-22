import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			int size = Integer.parseInt(br.readLine());
			int[][] map = new int[size][size];
			for (int r = 0; r < size; r++) {
				String str = br.readLine();
				for (int c = 0; c < size; c++) {
					map[r][c] = str.charAt(c)-'0';
				}
			}
			
			int profit = 0;
			for(int r = 0; r < size; r++) {
				if (r <= size/2) {
					for(int c = size/2-r; c <= size/2+r; c++) {
						profit += map[r][c];
					}
				} else {
					for(int c = r-size/2; c <= size/2*3-r; c++) {
						profit += map[r][c];
					}
				}
			}
			sb.append("#"+i+" "+profit+"\n");
		}
		System.out.println(sb);
	}
}