import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);
				for (int r = 0; r < R; r++) {
					sb.append(c);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
