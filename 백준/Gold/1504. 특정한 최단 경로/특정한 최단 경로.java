import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		List<int[]>[] map = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			map[start].add(new int[] { goal, dist });
			map[goal].add(new int[] {start, dist});
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		long[] shortcut = new long[n + 1];
		int[] passPoint = new int[3];
		passPoint[0] = 1;
		passPoint[1] = start;
		passPoint[2] = end;
		long[] distSum = new long[2];
		for (int i = 0; i < 3; i++) {
			int startPoint = passPoint[i];
			for (int j = 1; j <= n; j++) {
				shortcut[j] = Integer.MAX_VALUE;
			}
			shortcut[startPoint] = 0;
			Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});

			pq.offer(new int[] { startPoint, 0 });

			while (!pq.isEmpty()) {
				int[] current = pq.poll();
				int currentVertex = current[0];
				int currentDistance = current[1];


				if (currentDistance > shortcut[currentVertex])
					continue;

				for (int[] next : map[currentVertex]) {
					int nextVertex = next[0];
					int nextDistance = next[1];

					int newDistance = currentDistance + nextDistance;
					if (newDistance < shortcut[nextVertex]) {
						shortcut[nextVertex] = newDistance;
						pq.offer(new int[] { nextVertex, newDistance });
					}
				}
			}

			switch (i) {
			case 0:
				distSum[0] += shortcut[start];
				distSum[1] += shortcut[end];
				break;
			case 1:
				distSum[0] += shortcut[end];
				distSum[1] += shortcut[n];
				break;
			case 2:
				distSum[0] += shortcut[n];
				distSum[1] += shortcut[start];
				break;
			}
		}
		int result = -1;
		if (Math.min(distSum[0],distSum[1]) < Integer.MAX_VALUE) {
			result = (int)Math.min(distSum[0],distSum[1]);
		}
		System.out.print(result);		
	}
}