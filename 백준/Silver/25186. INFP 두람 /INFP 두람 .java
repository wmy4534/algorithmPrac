import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			sum += arr[i];
		}
		Arrays.sort(arr);
		long targetNum = sum / 2; // 7 3 8 4
		if (sum == 1) {
			System.out.println("Happy");
			return;
		}
		if (arr[N - 1] <= targetNum)
			System.out.println("Happy");
		else
			System.out.println("Unhappy");
	}
}
