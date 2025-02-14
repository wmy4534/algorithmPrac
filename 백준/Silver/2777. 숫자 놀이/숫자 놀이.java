import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int answer = -1;
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			if (N < 10) {
				sb.append(1).append("\n");
				continue;
			}
			int max = 9;
			for (; max > 1; ) {
				if (N % max == 0) {
					N /= max;
					count++;
					continue;
				}
				max--;
			}
			if (N == 1) {
				answer = count;
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}
