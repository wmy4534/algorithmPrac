import java.util.*;
import java.io.*;

class Building {
	int num;
	int time;
	Set<Building> prev = new HashSet<>();
	List<Building> next = new ArrayList<>();

	Building(int num, int time) {
		this.num = num;
		this.time = time;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 건물의개수
			int K = Integer.parseInt(st.nextToken()); // 건물순서규칙
			Building[] buildings = new Building[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int time = Integer.parseInt(st.nextToken());
				buildings[i] = new Building(i, time);
			}
			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int prev = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				buildings[prev].next.add(buildings[next]);
				buildings[next].prev.add(buildings[prev]);
			}
			
			int goal = Integer.parseInt(br.readLine());
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});

			for (int i = 1; i <= N; i++) {
				if (buildings[i].prev.size() == 0) {
					pq.offer(new int[] { i, buildings[i].time });
				}
			}

			while (!pq.isEmpty()) {
				int[] tmp = pq.poll();
				int num = tmp[0];
				int time = tmp[1];
				if (num == goal) {
					sb.append(time).append("\n");
					break;
				}
				for (Building building : buildings[num].next) {
					building.prev.remove(buildings[num]);
					if (building.prev.size() == 0) {
						pq.offer(new int[] {building.num, time + building.time});
					}
				}
			}
		}
		System.out.println(sb);
	}
}