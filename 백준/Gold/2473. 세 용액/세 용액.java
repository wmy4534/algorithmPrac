import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static int[] answer = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		for (int left = 0; left < N - 2; left++) {
			int right = N - 1;
			int mid = left + 1;
			while (mid < right) {
				long sum = arr[left] + arr[mid] + arr[right];
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					answer[0] = left;
					answer[1] = mid;
					answer[2] = right;
				}
				if (sum > 0L) {
					right--;
				} else if (sum < 0L) {
					mid++;
				} else {
					break;
				}
			}
			if (min == 0L)
				break;
		}
		System.out.print(arr[answer[0]] + " " + arr[answer[1]] + " " + arr[answer[2]]);
	}
}
