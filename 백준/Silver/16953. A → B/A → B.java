import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		Queue<Long> queue = new LinkedList<>();
		queue.offer(A);
		int result = -1;
		int count = 1;
		Bfs: while (!queue.isEmpty()) {
			count++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				long num = queue.poll();
				long num1 = num * 2;
				if (num1 < B) {
					queue.offer(num1);
				}
				long num2 = num * 10 + 1;
				if (num2 < B) {
					queue.offer(num2);
				}
				if (num1 == B || num2 == B) {
					result = count;
					break Bfs;
				}
			}
		}
		System.out.println(result);
	}
}