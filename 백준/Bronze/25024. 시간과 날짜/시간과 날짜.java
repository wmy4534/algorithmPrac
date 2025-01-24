import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] calendar = new int[13];
		calendar[1] = 31;
		calendar[2] = 29;
		calendar[3] = 31;
		calendar[4] = 30;
		calendar[5] = 31;
		calendar[6] = 30;
		calendar[7] = 31;
		calendar[8] = 31;
		calendar[9] = 30;
		calendar[10] = 31;
		calendar[11] = 30;
		calendar[12] = 31;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x >= 0 && x < 24 && y >= 0 && y < 60) {
				sb.append("Yes").append(" ");
			} else {
				sb.append("No").append(" ");
			}
			if (x > 0 && x <= 12) {
				if (y > 0 && y <= calendar[x]) {
					sb.append("Yes").append("\n");
				} else {
					sb.append("No").append("\n");
				}
			} else {
				sb.append("No").append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
