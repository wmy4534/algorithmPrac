import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			map.put(num, i);
			max = Math.max(max, num);
		}
		int[] score = new int[N];
		for (int i = 0; i < N; i++) {
			int num = arr[i];
			int multi = 2;
			int n = num;
			while (n <= max) {
				n = num * multi++;
				if (map.containsKey(n)) {
					score[i]++;
					score[map.get(n)]--;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			sb.append(score[i]).append(" ");
		}
		System.out.println(sb);
		br.close();
	}
}
