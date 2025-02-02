import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static boolean[] visited;
	static List<Integer>[] before;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 도시의 수
		int m = Integer.parseInt(br.readLine()); // 도로의
		List<Integer>[] cities = new ArrayList[n + 1];
		List<Integer>[] dists = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			cities[i] = new ArrayList<>();
			dists[i] = new ArrayList<>();
		}
		int[] prevCnt = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			cities[start].add(end);
			dists[start].add(dist);
			prevCnt[end]++;
		}

		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());

		Deque<Integer> dq = new ArrayDeque<>();
		dq.offerLast(first);

		before = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			before[i] = new ArrayList<>();
		}
		int[] longest = new int[n + 1];
		while (!dq.isEmpty()) {
			int start = dq.pollFirst();
			for (int i = 0; i < cities[start].size(); i++) {
				int end = cities[start].get(i);
				int add = dists[start].get(i);
				if (longest[end] < longest[start] + add) {
					longest[end] = longest[start] + add;
					before[end].clear();
					before[end].add(start);
				} else if (longest[end] == longest[start] + add) {
					before[end].add(start);
				}
				prevCnt[end]--;
				if (prevCnt[end] == 0) {
					dq.offerLast(end);
				}
			}
		}
		visited = new boolean[n + 1];
		dfs(goal);
		System.out.println(longest[goal] + "\n" + count);
	}

	private static void dfs(int next) {
		if (visited[next])
			return;
		visited[next] = true;
		for (int i = 0; i < before[next].size(); i++) {
			dfs(before[next].get(i));
			count++;
		}

	}
}
