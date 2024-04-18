import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int mid = sc.nextInt();
		sb.append(mid).append("\n");
		PriorityQueue<Integer> prevPQ = new PriorityQueue<>(Collections.reverseOrder()); // 중간값보다 작은 큐
		PriorityQueue<Integer> nextPQ = new PriorityQueue<>(); // 중간값보다 큰 큐
		for (int i = 1; i < N; i++) {
			int num = sc.nextInt(); // 다음에 부른 수
			if (num > mid) {
				nextPQ.offer(num);
			} else {
				prevPQ.offer(num);
			}
			int prevSize = prevPQ.size();
			int nextSize = nextPQ.size();
			int gap = prevSize - nextSize;
			if (gap >= 2) { // 작은 수가 더 많다
				nextPQ.offer(mid);
				mid = prevPQ.poll();
			} else if (gap > 0) { // 작은 수가 한 개 더 많으면
				nextPQ.offer(mid);
				mid = prevPQ.poll();
			} else if (gap <= -2) { // 큰 수가 더 많다
				prevPQ.offer(mid);
				mid = nextPQ.poll();
			}
			sb.append(mid).append("\n");
		}
		System.out.print(sb);
	}
}