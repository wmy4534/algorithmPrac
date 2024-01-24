import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int boxCount = Integer.parseInt(st.nextToken());
			int changeCount = Integer.parseInt(st.nextToken());
			int[] box = new int[boxCount+1];
			for(int c = 1; c <= changeCount; c++) {
				st = new StringTokenizer(br.readLine());
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				for(int l = left; l <= right; l++) {
					box[l] = c;
				}
			}
			sb.append("#"+t+" ");
			for(int i = 1; i < boxCount+1; i++) {
				sb.append(box[i]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}