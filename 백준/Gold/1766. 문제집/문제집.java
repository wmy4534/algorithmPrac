import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 문제의 수
		int M = Integer.parseInt(st.nextToken()); // 문제의 정보의 수
		int[] workbook = new int[N + 1];
		List<Integer>[] list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int q1 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			workbook[q2]++;
			list[q1].add(q2);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (workbook[i] == 0)
				pq.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int q = pq.poll();
			sb.append(q).append(" ");
			List<Integer> tmp = list[q];
			for (int i = 0; i < tmp.size(); i++) {
				int idx = tmp.get(i);
				workbook[idx]--;
				if (workbook[idx] == 0) 
					pq.offer(idx);
			}
		}
		System.out.println(sb);
	}
}
