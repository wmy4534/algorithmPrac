import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		int num = A;
		Deque<Integer> dq = new ArrayDeque<>();
		while (!set.contains(num)) {
			set.add(num);
			dq.offer(num);
			int sum = 0;
			while (num > 0) {
				sum += Math.pow(num % 10, P);
				num /= 10;
			}
			num = sum;
		}
		int count = 0;
		while (!dq.isEmpty()) {
			int tmp = dq.pollFirst();
			if (tmp == num)
				break;
			count++;
		}
		System.out.println(count);
	}
}
