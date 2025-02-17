import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 부서의 수
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int n = 0; n < num; n++) {
				arr[i] += Long.parseLong(st.nextToken());;
			}
		}
		Arrays.sort(arr);
		long result = 0;
		for (int i = 0; i < N; i++) {
			result += arr[i] * (N - i);
		}
		System.out.println(result);
	}
}
