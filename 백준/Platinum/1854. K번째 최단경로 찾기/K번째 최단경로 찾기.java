import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<int[]>[] map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a].add(new int[] { b, c });
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
			
		});
		int[] kdist = new int[n+1];
		Arrays.fill(kdist, -k);
		pq.add(new int[] {1, 0});
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if (kdist[tmp[0]] < -1) {
				kdist[tmp[0]]++;
				for (int i = 0; i < map[tmp[0]].size(); i++) {
					pq.offer(new int[] {map[tmp[0]].get(i)[0], map[tmp[0]].get(i)[1] + tmp[1]});
				}
			} else if (kdist[tmp[0]] == -1){
				kdist[tmp[0]] = tmp[1];
				for (int i = 0; i < map[tmp[0]].size(); i++) {
					pq.offer(new int[] {map[tmp[0]].get(i)[0], map[tmp[0]].get(i)[1] + tmp[1]});
				}
			} else {
				continue;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (kdist[i] <= -1) {
				sb.append(-1).append("\n");
			} else {
				sb.append(kdist[i]).append("\n");
			}
		}
		System.out.print(sb);
	}
}