import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static StringTokenizer st;
	static int start;
	static int end;
	static int cost;
	static Integer[] goalAndCost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		List<Integer[]>[] map = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<Integer[]>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			map[start].add(new Integer[] { end, cost });
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		Integer[] minCost = new Integer[n + 1];
//		Integer[] prevCity = new Integer[n + 1];
		Map<Integer, Integer> prev = new HashMap<>();
		for (int i = 0; i < map[start].size(); i++) {
			goalAndCost = map[start].get(i);
			if (minCost[goalAndCost[0]] == null) {
				queue.offer(goalAndCost[0]);
				minCost[goalAndCost[0]] = goalAndCost[1];
//			prevCity[goalAndCost[0]] = start;
				prev.put(goalAndCost[0], start);
			} else if (minCost[goalAndCost[0]] > goalAndCost[1]) {
				minCost[goalAndCost[0]] = goalAndCost[1];
			}
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int from = queue.poll();
				for (int i = 0; i < map[from].size(); i++) {
					goalAndCost = map[from].get(i);
					if (minCost[goalAndCost[0]] == null) {
						queue.offer(goalAndCost[0]);
						minCost[goalAndCost[0]] = goalAndCost[1] + minCost[from];
//						prevCity[goalAndCost[0]] = from;
						prev.put(goalAndCost[0], from);
					} else if (minCost[goalAndCost[0]] > goalAndCost[1] + minCost[from]) {
						queue.offer(goalAndCost[0]);
						minCost[goalAndCost[0]] = goalAndCost[1] + minCost[from];
//						prevCity[goalAndCost[0]] = from;
						prev.replace(goalAndCost[0], from);
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(minCost[end]).append("\n");
		Integer tmp = end;
		List<Integer> list = new ArrayList<>();
		while (tmp != start) {
			list.add(tmp);
			tmp = prev.get(tmp);
		}
		list.add(start);
		sb.append(list.size()).append("\n");
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.print(sb);
	}
}