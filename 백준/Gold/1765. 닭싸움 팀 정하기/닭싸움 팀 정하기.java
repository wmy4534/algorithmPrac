import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static List<Integer>[][] students;
	static List<List<Integer>> list;
	static boolean[] include;
	static List<Integer> tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 학생 수
		m = Integer.parseInt(br.readLine()); // 관계 수
		students = new ArrayList[n + 1][2]; // 0 : 친구 / 1 : 원수
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 2; j++) {
				students[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean isFriend = st.nextToken().equals("F");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (isFriend) {
				students[a][0].add(b);
				students[b][0].add(a);
			} else {
				students[a][1].add(b);
				students[b][1].add(a);
			}
		}

		list = new ArrayList<>();
		include = new boolean[n + 1];
		for (int r = 1; r <= n; r++) { // 1번부터
			if (include[r])
				continue;
			tmp = new ArrayList<>();
			tmp.add(r);
			friend(r);
			enemyEnemy(r);
			
			list.add(tmp);
		}
		System.out.println(list.size());
	}

	private static void friend(int r) {
		boolean[] visited = new boolean[n + 1]; // 속했나, 안속했나만 확인
		visited[r] = true;

		Deque<Integer> dq = new ArrayDeque<>();
		dq.offerLast(r);
		while (!dq.isEmpty()) { // 친구 먼저
			int st = dq.pollFirst();
			for (int i = 0; i < students[st][0].size(); i++) {
				int idx = students[st][0].get(i);
				if (visited[idx])
					continue;
				dq.offerLast(idx);
				visited[idx] = true;
				tmp.add(idx);
				include[idx] = true;
			}
		}
	}

	private static void enemyEnemy(int r) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offerLast(r);
		boolean[] visited = new boolean[n + 1];
		visited[r] = true;
		while (!dq.isEmpty()) { // 원수의 원수 찾기
			int st = dq.pollFirst();
			for (int i = 0; i < students[st][1].size(); i++) { // 얘는 원수들
				int enemy = students[st][1].get(i);
				if (visited[enemy])
					continue;
				for (int j = 0; j < students[enemy][1].size(); j++) { // 원수의 원수들
					int enemyEnemy = students[enemy][1].get(j);
					if (visited[enemyEnemy])
						continue;
					friend(enemyEnemy);
					dq.offerLast(enemyEnemy);
					visited[enemyEnemy] = true;
					tmp.add(enemyEnemy);
					include[enemyEnemy] = true;
				}
			}
		}

	}
}