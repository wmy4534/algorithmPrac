import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static List<int[]>[] networks;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		networks = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			networks[i] = new ArrayList<int[]>();
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			networks[A].add(new int[] { B, C });
			networks[B].add(new int[] { A, C });
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return arr1[2] - arr2[2];
			}
		});
		int visitNum = 1;
		visited[1] = true; // 1번 슈퍼컴퓨터에서 시작
		for (int[] arr : networks[1]) {
			pq.offer(new int[] { 1, arr[0], arr[1] });
		}
		List<Point> points = new ArrayList<>();

		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int from = tmp[0];
			int start = tmp[1];
			int dist = tmp[2];
			if (visited[start]) { // 전에 방문한 곳이면 패스
				continue;
			} else {
				visited[start] = true;
			}
			visitNum++;
			Point point = new Point(from, start);
			points.add(point);
			if (visitNum == N) {
				break;
			}
			for (int[] arr : networks[start]) {
				if (visited[arr[0]]) // 방문한 곳이면 패스
					continue;
				pq.offer(new int[] { start, arr[0], arr[1] + dist });
			}
		}
		sb.append(points.size()).append("\n");
		for (Point point : points) {
			sb.append(point.x).append(" ").append(point.y).append("\n");
		}
		System.out.print(sb);

	}
}