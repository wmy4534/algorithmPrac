import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] compass = new int[6];
		int[] lengths = new int[6];
		int[] doubleCompass = new int[2];
		int maxWidth = 0;
		int maxHeight = 0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			compass[i] = Integer.parseInt(st.nextToken());
			lengths[i] = Integer.parseInt(st.nextToken());
			if (compass[i] >= 3 && maxWidth < lengths[i])
				maxWidth = lengths[i];
			else if (compass[i] < 3 && maxHeight < lengths[i])
				maxHeight = lengths[i];
		}
		int smallSum = 0;
		Loop: for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				if (compass[i] == compass[j]) {
					if (j - i == 2) {
						if (compass[i + 1] == compass[(j + 1) % 6]) {
							smallSum = lengths[j - 1] * lengths[j];
							break Loop;
						} else if (compass[(i - 1 + 6) % 6] == compass[j - 1]) {
							smallSum = lengths[i] * lengths[i + 1];
							break Loop;
						}
					} else {
						if (compass[i + 1] == compass[(j + 1) % 6]) {
							smallSum = lengths[(j + 1) % 6] * lengths[i];
							break Loop;
						} else {
							smallSum = lengths[(i - 1 + 6) % 6] * lengths[j];
							break Loop;
						}
					}
				}
			}
		}
		int result = maxWidth * maxHeight - smallSum;
		System.out.println(result * count);

	}
}