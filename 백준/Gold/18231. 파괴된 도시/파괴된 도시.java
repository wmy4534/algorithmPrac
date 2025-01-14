import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수 <= 100,000
		List<Integer>[] map = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int city1 = Integer.parseInt(st.nextToken());
			int city2 = Integer.parseInt(st.nextToken());
			map[city1].add(city2);
			map[city2].add(city1);
		}
		
		boolean[] bombs = new boolean[N + 1];
		Arrays.fill(bombs, true);
		int T = Integer.parseInt(br.readLine()); // 폭탄이 떨어진 도시의 번호
		st = new StringTokenizer(br.readLine());
		for (int t = 0; t < T; t++) {
			int city = Integer.parseInt(st.nextToken());
			bombs[city] = false;
		}
		int answer = 0;
		StringBuilder sb = new StringBuilder();

		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (bombs[i])
				continue;
			List<Integer> list = new ArrayList<>();
			list.add(i);
			List<Integer> tmp = map[i];
			boolean isPossible = true;
			for (int idx = 0; idx < tmp.size(); idx++) {
				int city = tmp.get(idx);
				if (bombs[city]) {
					isPossible = false;
					break;
				}
				list.add(city);
			}
			if (!isPossible)
				continue;
			answer++;
			sb.append(i).append(" ");
			for (int j = 0; j < list.size(); j++) {
				visited[list.get(j)] = true;
			}
		}
		
		for (int i = 0; i <= N; i++) {
			bombs[i] = (bombs[i] || visited[i]);
		}
		for (int i = 0; i <= N; i++) {
			if (!bombs[i]) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
		if (answer == -1)
			return;
		System.out.println(sb);
	}
}
