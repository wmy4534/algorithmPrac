import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long cnt = 0L;
		Deque<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (!dq.isEmpty()) {
				if (tmp > dq.peekLast()[0]) {
					while (!dq.isEmpty() && tmp > dq.peekLast()[0]) {
						cnt += dq.pollLast()[1];
					}
					if (!dq.isEmpty() && dq.peekLast()[0] == tmp) {
						cnt += dq.peekLast()[1];
						if (dq.size() > 1) {
							cnt++;
						}
					} else if (!dq.isEmpty()) {
						cnt++;
					}

				} else if (tmp < dq.peekLast()[0]) {
					cnt++;
				} else { // 같은 경우
					cnt += dq.peekLast()[1];
					if (dq.size() > 1) {
						cnt++;
					}
				}
			}
			int[] tmpArr = new int[] { tmp, 1 };
			if (!dq.isEmpty() && dq.peekLast()[0] == tmpArr[0]) {
				tmpArr[1] += dq.pollLast()[1];
				dq.offerLast(tmpArr);
			} else {
				dq.offerLast(tmpArr);
			}
		}
		System.out.print(cnt);
	}
}