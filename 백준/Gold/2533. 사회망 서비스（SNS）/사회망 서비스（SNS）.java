import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static List<Integer>[] list;
	static boolean[] visited;
	static int N, answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		int[] arr = new int[N + 1];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			list[parent].add(child);
			list[child].add(parent);
			arr[parent]++;
			arr[child]++;
		}
		
		find(1);
		System.out.println(answer);
	}
	private static boolean find(int parent) {
		visited[parent] = true;
		List<Integer> tmp = list[parent];
		int count = 0;
		for (int i = 0; i < tmp.size(); i++) {
			int num = tmp.get(i);
			if (visited[num] || find(num)) {
				continue;
			}
			count++;
		}
		
		if (count >= 1) {
			answer++;
			return true;
		} else {
			return false;
		}
		
	}
}
