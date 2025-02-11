import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine()); // numbers of room
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			sum += arr[i];
		}
		final long goal = sum / N;
		long chaos = 0;
		long rest = 0;
		for (int i = 0; i < N; i++) {
			chaos += Math.abs(rest);
			rest += arr[i] - goal;
		}
		System.out.println(chaos);
		
		
	}
}
