import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int diceNum = Integer.parseInt(br.readLine());
		int[][] dices = new int[diceNum][6];
		for (int d = 0; d < diceNum; d++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				dices[d][i] = Integer.parseInt(st.nextToken());
			}
		}
		int maxSum = 0;
		int sum = 0;
		int[] reverseSideIdx = { 5, 3, 4, 1, 2, 0 };
		int[][] downUpNum = new int[diceNum][2];
		for (int i = 0; i < 6; i++) {
			sum = 0;
			downUpNum[0][0] = dices[0][i];
			downUpNum[0][1] = dices[0][reverseSideIdx[i]];
			for(int n = 6; n > 0; n--) {
				if(n != downUpNum[0][0] && n != downUpNum[0][1]) {
					sum += n;
					break;
				}
			}
			for(int d = 1; d < diceNum; d++) {
				downUpNum[d][0] = downUpNum[d-1][1];
				int idx = 0;
				for(int id = 0; id < 6; id++) {
					if(dices[d][id] == downUpNum[d][0]) {
						idx = id;
						break;
					}
				}
				downUpNum[d][1] = dices[d][reverseSideIdx[idx]];
				for(int n = 6; n > 0; n--) {
					if(n != downUpNum[d][0] && n != downUpNum[d][1]) {
						sum += n;
						break;
					}
				}
			}
			if(maxSum < sum) {
				maxSum = sum;
			}
		}
		System.out.println(maxSum);
	}
}