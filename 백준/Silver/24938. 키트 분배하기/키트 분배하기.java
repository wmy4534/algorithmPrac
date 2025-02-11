import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine()); // numbers of room
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		final int goal = sum / N;
		int chaos = 0;
		int rest = 0;
		for (int i = 0; i < N; i++) {
			chaos += Math.abs(rest);
			rest += arr[i] - goal;
		}
		System.out.println(chaos);
		
		
	}
}
