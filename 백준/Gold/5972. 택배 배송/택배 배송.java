import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 헛간의 개수
		int M = Integer.parseInt(st.nextToken()); // 연결된 길의 수
		List<int[]>[] map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int feed = Integer.parseInt(st.nextToken());
			map[a].add(new int[] { b, feed });
			map[b].add(new int[] { a, feed });
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});
		for (int i = 0; i < map[1].size(); i++) {
			pq.offer(map[1].get(i));
		}
		Integer[] visited = new Integer[N + 1];
		visited[1] = 0;
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if (visited[tmp[0]] == null)
				visited[tmp[0]] = tmp[1];
			if (tmp[0] == N)
				break;
			for (int i = 0; i < map[tmp[0]].size(); i++) {
				int goal = map[tmp[0]].get(i)[0];
				if (visited[goal] != null)
					continue;
				int feed = map[tmp[0]].get(i)[1] + tmp[1];
				pq.offer(new int[] { goal, feed });
			}
		}
		System.out.print(visited[N]);
	}
}