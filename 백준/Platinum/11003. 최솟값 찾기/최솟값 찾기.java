import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Deque<int[]> dq = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());

			while (!dq.isEmpty() && dq.getFirst()[0] < i - L + 1) { // 앞 부분에 고려하지 않아도 될 범위 삭제
				dq.removeFirst();
			}
			while (!dq.isEmpty() && dq.getLast()[1] > num) { // 남아있는 값 중 지금 들어오는 값보다 큰 값들 삭제
				dq.removeLast();
			}

			dq.addLast(new int[] { i, num });

			sb.append(dq.getFirst()[1]).append(" "); // 값이 덱의 맨 앞에 있다는 건 그 뒤에 들어온 값들보단 작은 값이라는 뜻
		}

		System.out.print(sb);
	}
}