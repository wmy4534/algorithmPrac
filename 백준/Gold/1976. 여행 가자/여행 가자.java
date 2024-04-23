import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시 수
		int M = Integer.parseInt(br.readLine()); // 계획에 속한 도시 수
		boolean[][] map = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = st.nextToken().equals("1");
			}
		}
		boolean[][] path = new boolean[N + 1][N + 1]; // 각 점에서 갈 수 있는 위
		for (int i = 1; i <= N; i++) { // 각 시작점에서 갈 수 있는 위치 구하기
			Deque<Integer> dq = new ArrayDeque<>();

			for (int j = 1; j <= N; j++) {
				if (map[i][j] && !path[i][j]) {
					if (j < i) { // 더 작으면 이미 갈 수 있는 경로에 포함할 수 있음
						for (int k = 1; k <= N; k++) {
							if (path[j][k])
								path[i][k] = true;
						}
					} else {
						dq.offerLast(j);
						path[i][j] = true;
					}
				}
			}

			while (!dq.isEmpty()) {
				int start = dq.pollFirst();
				for (int k = 1; k <= N; k++) {
					if (map[start][k] && !path[i][k]) { // 만약 갈 수 있고, 아직 방문하지 않았다면
						dq.offerLast(k);
						path[i][k] = true;
					}
				}
			}
		}
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int city1 = Integer.parseInt(st.nextToken());
		for (int i = 1; i < M; i++) {
			int city2 = Integer.parseInt(st.nextToken());
			if (path[city1][city2] || city1 == city2) {
				city1 = city2;
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}