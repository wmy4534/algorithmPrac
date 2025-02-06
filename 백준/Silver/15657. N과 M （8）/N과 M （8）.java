import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] arr, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		answer = new int[M];
		Sequence(0, 0);
		System.out.print(sb);
		br.close();
	}

	private static void Sequence(int count, int idx) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = idx; i < N; i++) {
			answer[count] = arr[i];
			Sequence(count + 1, i);
		}
	}
}
