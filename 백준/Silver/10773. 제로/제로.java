import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numCount = Integer.parseInt(br.readLine());
		int[] numArr = new int[numCount];
		for (int i = 0; i < numCount; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
			if (numArr[i] == 0) {
				for (int j = i - 1; j >= 0; j--) {
					if (numArr[j] != 0) {
						numArr[j] = 0;
						break;
					}
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < numCount; i++) {
			sum += numArr[i];
		}
		System.out.println(sum);
	}
}