import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 키 비교 횟수
		int[] arr = new int[N + 1];
		List<Integer>[] lists = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			lists[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			lists[first].add(second);
			arr[second]++;
		}
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				dq.offerLast(i);
			}
		}

		while (!dq.isEmpty()) {
			int idx = dq.pollFirst();
			sb.append(idx).append(" ");
			arr[idx] = -1;
			for (int i = 0; i < lists[idx].size(); i++) {
				int rest = lists[idx].get(i);
				arr[rest]--;
				if (arr[rest] == 0) {
					dq.offerLast(rest);
				}
			}
		}
		System.out.println(sb);
	}
}
