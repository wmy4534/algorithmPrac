import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int minCount = Integer.MAX_VALUE;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		findMinCount(num);
		System.out.println(minCount);

	}

	private static void findMinCount(int num) {
		if (count >= minCount)
			return;
		if (num < 1)
			return;
		if (num == 1) {
			if (count < minCount) {
				minCount = count;
			}
			return;
		}
		if (num % 3 == 0) {
			count++;
			findMinCount(num / 3);
			count--;
		}
		if (num % 2 == 0) {
			count++;
			findMinCount(num / 2);
			count--;
		}
		count++;
		findMinCount(num-1);
		count--;
	}
}