import java.util.*;
import java.io.*;

public class Main {
	
	static long[] arr;
	static int N;
	static long answer;
	static long mod = 1000000007L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0L;
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			long tmp = (calc(i) - calc(N - i - 1)) % mod;
			tmp *= arr[i];
			answer += tmp;
			answer %= mod;
		}
		System.out.println(answer);
		br.close();
	}
	
	private static long calc(int i) {
		if (i == 1) {
			return 2L;
		} else if (i == 0) {
			return 1L;
		}
		
		long result = 0L;
		if (i % 2 == 0) {
			result = calc(i / 2) % mod;
			result = (result * result) % mod;
		} else {
			result = calc(i / 2) % mod;
			result = (result * result * 2) % mod;
		}
		return result;
	}
}
