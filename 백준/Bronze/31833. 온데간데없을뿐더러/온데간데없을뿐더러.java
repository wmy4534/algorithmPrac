import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		long[] brr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			sb.append(arr[i]);
		}
		long answer = Long.parseLong(sb.toString());
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			brr[i] = Long.parseLong(st.nextToken());
			sb.append(brr[i]);
		}
		answer = Math.min(answer, Long.parseLong(sb.toString()));
		System.out.println(answer);
		
	}
}