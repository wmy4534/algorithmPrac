import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 우주의 개수
		int N = Integer.parseInt(st.nextToken()); // 행성의 개수
		int[][] universe = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] arr1, int[] arr2) {
					return arr1[1] == arr2[1] ? arr1[0] - arr2[0] : arr1[1] - arr2[1];
				}
			});
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				pq.offer(new int[] { j, num });
			}
			int order = 0;
			int before = Integer.MAX_VALUE;
			while (!pq.isEmpty()) {
				int[] tmp = pq.poll();
				if (before == tmp[1]) {
					universe[i][tmp[0]] = order;
				} else {
					universe[i][tmp[0]] = ++order;
				}
				before = tmp[1];
			}
		}
		String[] strArr = new String[M];
		for (int i = 0; i < M; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < N; j++) {
				sb.append(universe[i][j]).append(" ");
			}
			strArr[i] = sb.toString();
		}
		universe = null;
		Arrays.sort(strArr);
		String base = strArr[0];
		int count = 1;
		int answer = 0;
		for (int i = 1; i < M; i++) {
			if (strArr[i].equals(base)) {
				count++;
			} else {
				answer += count * (count - 1) / 2;
				count = 1;
				base = strArr[i];
			}
		}
		answer += count * (count - 1) / 2;
		System.out.println(answer);
	}
}
