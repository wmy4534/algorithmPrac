import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Deque<Character> ldq = new ArrayDeque<>();
		Deque<Character> rdq = new ArrayDeque<>();
		for (int i = 0; i < str.length(); i++) {
			ldq.offerLast(str.charAt(i));
		}
		int M = Integer.parseInt(br.readLine()); // 명령어의 수
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			switch (tmp) {
			case "L":
				if (ldq.isEmpty())
					break;
				else {
					rdq.offerLast(ldq.pollLast());
				}
				break;
			case "D":
				if (rdq.isEmpty())
					break;
				else {
					ldq.offerLast(rdq.pollLast());
				}
				break;
			case "B":
				if (ldq.isEmpty())
					break;
				else {
					ldq.pollLast();
				}
				break;
			case "P":
				String s = st.nextToken();
				ldq.offerLast(s.charAt(0));
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!ldq.isEmpty()) {
			sb.append(ldq.pollFirst());
		}
		while (!rdq.isEmpty()) {
			sb.append(rdq.pollLast());
		}
		System.out.println(sb);
	}
}