import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[N];
		int[] d = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		int[] sum1 = new int[N * N];
		int[] sum2 = new int[N * N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int idx = i * N + j;
				sum1[idx] = a[i] + b[j];
				sum2[idx] = c[i] + d[j];
			}
		}
		Arrays.sort(sum1);
		Arrays.sort(sum2);
		long answer = 0L;
		int lpoint = 0;
		int rpoint = sum2.length - 1;
		for (; lpoint < sum1.length; lpoint++) {
			for (; rpoint >= 0; rpoint--) {
				int sum = sum1[lpoint] + sum2[rpoint];
				if (sum < 0)
					break;
				else if (sum > 0)
					continue;
				else { // sum == 0
					long lCnt = 1L;
					long rCnt = 1L;
					while (lpoint + 1 < sum1.length && sum1[lpoint] == sum1[lpoint + 1]) {
						lpoint++;
						lCnt++;
					}
					while (rpoint >= 1 && sum2[rpoint] == sum2[rpoint - 1]) {
						rpoint--;
						rCnt++;
					}
					answer += lCnt * rCnt;
				}
			}
		}
		System.out.println(answer);
	}
}