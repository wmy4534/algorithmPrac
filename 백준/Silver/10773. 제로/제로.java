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
		}
		int zeroCount = 0;
		int sum = 0;
		for (int i = (numCount - 1); i >= 0; i--) {
			if (zeroCount == 0) {
				if (numArr[i] == 0) {
					zeroCount++;
				} else
					sum += numArr[i];
			} else if (numArr[i] == 0) {zeroCount++;}
			else {zeroCount--;}
		}
		System.out.println(sum);
	}
}