import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] pillars = new int[num][2];

		int maxHeight = 0;
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pillars[i][0] = Integer.parseInt(st.nextToken());
			pillars[i][1] = Integer.parseInt(st.nextToken());
			if (pillars[i][1] > maxHeight) {
				maxHeight = pillars[i][1];
			}
		}

		Arrays.sort(pillars, (o1, o2) -> o1[0] - o2[0]);
		int maxIdx = 0;
		for (int i = 0; i < num; i++) {
			if (pillars[i][1] == maxHeight)
				maxIdx = i;
		}
		int sum = maxHeight;
		int height = pillars[0][1];
		for (int i = 0; i < maxIdx; i++) {
			if (height > pillars[i + 1][1]) {
				sum += height * (pillars[i + 1][0] - pillars[i][0]);
			} else {
				sum += height * (pillars[i + 1][0] - pillars[i][0]);
				height = pillars[i+1][1];
			}
		}
		
		height = pillars[num-1][1];
		for (int i = num-1; i > maxIdx; i--) {
			if (height > pillars[i - 1][1]) {
				sum += height * (pillars[i][0] - pillars[i - 1][0]);
			} else {
				sum += height * (pillars[i][0] - pillars[i - 1][0]);
				height = pillars[i-1][1];
			}
		}
		System.out.println(sum);
	}
}