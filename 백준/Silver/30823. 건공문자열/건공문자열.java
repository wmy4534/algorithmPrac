import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		for (int i = K - 1; i < N; i++) {
			sb.append(str.charAt(i));
		}
		if ((N - K + 1) % 2 == 0) {
			for (int i = 0; i < K - 1; i++) {
				sb.append(str.charAt(i));
			}
		} else {
			for (int i = K - 2; i >= 0; i--) {
				sb.append(str.charAt(i));
			}
		}
		System.out.println(sb);
	}
}
