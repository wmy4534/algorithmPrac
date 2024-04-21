import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수열의 개수
		int S = Integer.parseInt(st.nextToken()); // 합
		int[] arr = new int[N + 1];
		int[] preSum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			preSum[i] = arr[i] + preSum[i - 1];
		}
		int lpoint = 0;
		int minGap = Integer.MAX_VALUE;
		for (int rpoint = 0; rpoint <= N; rpoint++) {
			if (preSum[rpoint]-preSum[lpoint] >= S) {
				for (;lpoint <= rpoint; lpoint++) {
					if (preSum[rpoint] - preSum[lpoint] >= S) {
						if (minGap > rpoint - lpoint)
							minGap = rpoint - lpoint;
						continue;
					} else
						break;
				}
			}
		}
		if (minGap == Integer.MAX_VALUE)
			minGap = 0;
		bw.write(String.valueOf(minGap));
		bw.flush();
		bw.close();
	}
}