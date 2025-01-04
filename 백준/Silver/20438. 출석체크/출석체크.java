import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // student num
		int K = Integer.parseInt(st.nextToken()); // sleeping student num
		int Q = Integer.parseInt(st.nextToken()); // code receiving num
		int M = Integer.parseInt(st.nextToken()); // attendance check num
		boolean[] allStudent = new boolean[N + 3];
		Set<Integer> sleeping = new HashSet<>();
		int[] preSum = new int[N + 3];

		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			sleeping.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int q = 0; q < Q; q++) {
			int code = Integer.parseInt(st.nextToken());
			int tmp = code;
			int multi = 2;
			while (tmp < (N + 3) && !sleeping.contains(code)) {
				if (sleeping.contains(tmp)) {
					tmp = code * multi++;
					continue;
				}
				allStudent[tmp] = true;
				tmp = code * multi++;
			}
		}

		for (int i = 3; i < N + 3; i++) {
			preSum[i] = preSum[i - 1];
			if (!allStudent[i]) {
				preSum[i]++;
			}
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(preSum[end] - preSum[start - 1]).append("\n");
		}
		br.close();
		System.out.print(sb);
	}
}
