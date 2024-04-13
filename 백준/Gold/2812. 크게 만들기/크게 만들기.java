import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String initNum = sc.next();
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < initNum.length(); i++) {
			int num = Character.getNumericValue(initNum.charAt(i));
			while (K > 0 && !dq.isEmpty()) {
				int tmp = dq.peekLast();
				if (num > tmp) {
					dq.pollLast();
					K--;
				} else
					break;
			}
			dq.offerLast(num);
		}
		StringBuilder sb = new StringBuilder();
		int size = dq.size();
		for (int i = 0; i < size-K; i++) {
			sb.append(dq.pollFirst());
		}
		System.out.print(sb);
	}
}