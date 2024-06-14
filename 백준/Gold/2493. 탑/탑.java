import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Deque<int[]> dq = new ArrayDeque<int[]>();
		int[] result = new int[N+1];
		for (int i = N; i > 0; i--) {
			while (!dq.isEmpty()) {
				int[] tmp = dq.pollLast();
				if (arr[i] >= tmp[1])
					result[tmp[0]] = i;
				else {
					dq.offerLast(tmp);
					break;
				}
			}
			dq.offerLast(new int[] { i, arr[i] });
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.print(sb);
	}
}