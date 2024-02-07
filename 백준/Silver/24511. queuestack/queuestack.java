import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 자료구조의 수
		int[] stackOrQueue = new int[N];
		int[] numArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stackOrQueue[i] = Integer.parseInt(st.nextToken()); // 자료구조
		}
		Stack<Integer> numStack = new Stack<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken()); // 각각 원소 넣기
			if (stackOrQueue[i] == 0)
				numStack.push(numArr[i]);
		}
		Queue<Integer> numQueue = new LinkedList<>();
		int M = Integer.parseInt(br.readLine()); // 삽입할 수의 개수
		st = new StringTokenizer(br.readLine()); // 삽입할 수열
		for (int i = 0; i < M - numStack.size(); i++) {
			int num = Integer.parseInt(st.nextToken());
			numQueue.offer(num);
		}
		int count = 0;
		while (count < M) {
			if (!numStack.isEmpty())
				sb.append(numStack.pop() + " ");
			else
				sb.append(numQueue.poll() + " ");
			count++;
		}
		System.out.println(sb);
	}
}