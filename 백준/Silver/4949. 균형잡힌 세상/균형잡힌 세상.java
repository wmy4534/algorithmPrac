import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {

	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null && !str.equals(".")) {
			boolean isBalance = true;
			Deque<Character> dq = new ArrayDeque<>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				switch (c) {
				case '(':
					dq.offerLast(c);
					break;
				case '[':
					dq.offerLast(c);
					break;
				case ')':
					if (dq.size() > 0) {
						char last = dq.pollLast();
						if (last == '(') {
							continue;
						} else {
							isBalance = false;
						}
					} else {
						isBalance = false;
					}
					break;
				case ']':
					if (dq.size() > 0) {
						char last = dq.pollLast();
						if (last == '[') {
							continue;
						} else {
							isBalance = false;
						}
					} else {
						isBalance = false;
					}
					break;
				}
				if (!isBalance) {
					break;
				}
			}
			if (isBalance && dq.size() == 0) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
