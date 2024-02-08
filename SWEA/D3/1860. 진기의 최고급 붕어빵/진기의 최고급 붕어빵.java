import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine()); // 손님 도착시간 입력
			int[] customerEnterTime = new int[N];
			for (int n = 0; n < N; n++) {
				customerEnterTime[n] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(customerEnterTime);
			
			int[] time = new int[customerEnterTime[N - 1] + 2];

			for (int i = 0; i < N; i++) {
				time[customerEnterTime[i]]--;
			}

			boolean result = true;
			for (int i = 0; i < time.length - 1; i++) {
				if (i > 0 && i % M == 0) {
					time[i] += K;
				}
				if (time[i] < 0) {
					result = false;
					break;
				}
				time[i + 1] += time[i];
			}
			if (result)
				sb.append("#" + t + " Possible\n");
			else
				sb.append("#" + t + " Impossible\n");
		}
		System.out.println(sb);

	}
}