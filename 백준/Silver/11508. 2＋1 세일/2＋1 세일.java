import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		long lowestPrice = 0L;
		Arrays.sort(arr);
		int setCnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			setCnt++;
			if (setCnt >= 3) {
				setCnt = 0;
				continue;
			}
			lowestPrice += arr[i];
		}
		System.out.println(lowestPrice);
	}
}
