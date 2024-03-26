import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine()); // 시작점

        map = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[u].add(new int[]{v, w});
        }

        // 최단 거리를 저장하는 배열
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); // 최단 거리를 저장하는 배열을 무한대로 초기화
        distance[start] = 0; // 시작점의 거리는 0

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
        });
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentVertex = current[0];
            int currentDistance = current[1];

            if (currentDistance > distance[currentVertex])
                continue;

            for (int[] next : map[currentVertex]) {
                int nextVertex = next[0];
                int weight = next[1];

                int newDistance = currentDistance + weight;
                if (newDistance < distance[nextVertex]) {
                    distance[nextVertex] = newDistance;
                    pq.offer(new int[]{nextVertex, newDistance});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(distance[i]).append("\n");
        }

        System.out.print(sb);
    }
}