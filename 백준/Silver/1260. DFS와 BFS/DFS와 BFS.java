import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	static boolean[] visited;
	static int N, M, V;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점
		map = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs();
		System.out.print(sb);
	}
	
	private static void bfs() {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(V);
		visited[V] = true;
		while (!dq.isEmpty()) {
			int point = dq.pollFirst();
			sb.append(point).append(" ");
			for (int i = 1; i <= N; i++) {
				if (map[point][i] && !visited[i]) {
					dq.offerLast(i);
					visited[i] = true;
				}
			}
		}
	}

	private static void dfs(int point) {
		visited[point] = true;
		sb.append(point).append(" ");
		for (int i = 1; i <= N; i++) {
			if (map[point][i] && !visited[i])
				dfs(i);
		}
	}
}