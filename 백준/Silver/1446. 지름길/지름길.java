import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 지름길의 개수
		int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이
		int[] distance = new int[D + 1]; // 길이별 최단 거리
		for (int i = 0; i <= D; i++) {
			distance[i] = i;
		}
		int[][] shortcut = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			shortcut[i][0] = Integer.parseInt(st.nextToken()); // start point
			shortcut[i][1] = Integer.parseInt(st.nextToken()); // end point
			shortcut[i][2] = Integer.parseInt(st.nextToken()); // distance
		}
		Arrays.sort(shortcut, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		}); // end point 가 작은 순서대로
		for (int i = 0; i < N; i++) {
			if (shortcut[i][1] > D) // end point 를 넘었을 경우
				break;
			int sp = shortcut[i][0]; // start point
			int ep = shortcut[i][1]; // end point
			int dist = shortcut[i][2]; // distance
			if (distance[ep] <= distance[sp] + dist)
				continue;
			distance[ep] = distance[sp] + dist;
			for (int j = ep + 1; j <= D; j++) {
				distance[j] = distance[j - 1] + 1;
			}
		}
		System.out.println(distance[D]);
	}
}