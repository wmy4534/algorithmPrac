import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfStairs = Integer.parseInt(br.readLine());
		int[] stairs = new int[numOfStairs];
		for (int i = 0; i < numOfStairs; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		if (numOfStairs < 3) { // 계단의 수가 3보다 작을 경우 처리
			int sum = 0;
			for (int i = 0; i < numOfStairs; i++) {
				sum += stairs[i];
			}
			System.out.println(sum);
			return;
		}

		int[][] maxSumofStairs = new int[numOfStairs][2];
		maxSumofStairs[numOfStairs - 1][0] = stairs[numOfStairs - 1];
		maxSumofStairs[numOfStairs - 1][1] = stairs[numOfStairs - 1];
		maxSumofStairs[numOfStairs - 2][0] = stairs[numOfStairs - 2];
		maxSumofStairs[numOfStairs - 2][1] = stairs[numOfStairs - 2] + maxSumofStairs[numOfStairs - 1][0];
		maxSumofStairs[numOfStairs - 3][0] = maxSumofStairs[numOfStairs - 1][0] + stairs[numOfStairs - 3];
		maxSumofStairs[numOfStairs - 3][1] = maxSumofStairs[numOfStairs - 3][0];

		for (int i = numOfStairs - 4; i >= 0; i--) {
			maxSumofStairs[i][0] = Math.max(maxSumofStairs[i + 2][0], maxSumofStairs[i + 2][1]) + stairs[i];
			maxSumofStairs[i][1] = maxSumofStairs[i + 1][0] + stairs[i]; // 한 칸 떨어진 계단의 합
		}
		int max = Math.max(maxSumofStairs[0][0], maxSumofStairs[0][1]); // 제일 앞 계단에서 큰 값을 비교하고
		max = Math.max(max, maxSumofStairs[1][1]); // 그 다음 계단에서 큰 값과 비교
		System.out.println(max);
	}
}