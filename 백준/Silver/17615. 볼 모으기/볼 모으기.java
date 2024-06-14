import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] balls = new boolean[N];
		String tmp = br.readLine();
		int red = 0;
		int blue = 0;
		for (int i = 0; i < N; i++) {
			balls[i] = tmp.charAt(i) == 'R'; // 빨간색 공이면 true 파란색 공이면 false
			if (balls[i])
				red++;
			else
				blue++;
		}
		boolean left = balls[0]; // 가장 왼쪽 볼 색깔
		boolean right = balls[N-1]; // 가장 오른쪽 볼 색깔
		// red ball = true
		int leftNum = 1;
		for (int i = 1; i < N; i++) {
			if (left != balls[i])
				break;
			leftNum++;
		}
		int rightNum = 1;
		for (int i = N-2; i >= 0; i--) {
			if (right != balls[i])
				break;
			rightNum++;
		}
		int minMove = Integer.MAX_VALUE;
		if (left) {
			minMove = red - leftNum;
		} else {
			minMove = blue - leftNum;
		}
		if (right) {
			minMove = Math.min(minMove, red-rightNum);
		} else {
			minMove = Math.min(minMove, blue-rightNum);
		}
		minMove = Math.min(minMove, Math.min(red, blue));
		System.out.println(minMove);
	}
}