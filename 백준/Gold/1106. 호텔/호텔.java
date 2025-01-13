import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()); // 늘려야 할 목표 고객 수
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수 N
		int[][] cities = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cities[i][0] = Integer.parseInt(st.nextToken()); // 비용
			cities[i][1] = Integer.parseInt(st.nextToken()); // 늘어나는 수
		}
		int[] arr = new int[C + 1];
		for (int i = 1; i <= C; i++) {
			arr[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < N; i++) {
			int cost = cities[i][0];
			int increase = cities[i][1];
			for (int c = 0; c <= C; c++) {
				int next = c + increase;
				if (next <= C && arr[c] != Integer.MAX_VALUE) {
					arr[next] = Math.min(arr[next], arr[c] + cost);
				} else if (next > C && arr[c] != Integer.MAX_VALUE) {
					arr[C] = Math.min(arr[C], arr[c] + cost);
				}
			}
		}
		System.out.println(arr[C]);
	}
}
