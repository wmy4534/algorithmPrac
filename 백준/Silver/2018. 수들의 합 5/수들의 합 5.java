import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = N; i > 0; i--) {
			int sum = 0;
			for (int j = i; j > 0; j--) {
				sum += j;
				if (sum == N) {
					count++;
					break;
				} else if (sum > N) {
					break;
				}
			}
			if (sum < N)
				break;
		}
		
		System.out.println(count);
	}
}
