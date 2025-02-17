import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			int H = 0;
			boolean isRight = false;
			if (a > b && a > c) {
				H = a;
				if (a * a == b * b + c * c) {
					isRight = true;
				}
			} else if (b > a && b > c) {
				H = b;
				if (b * b == a * a + c * c) {
					isRight = true;
				}
			} else if (c > a && c > b) {
				H = b;
				if (c * c == a * a + b * b) {
					isRight = true;
				}
			}
			if (isRight) {
				sb.append("right").append("\n");
			} else {
				sb.append("wrong").append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
