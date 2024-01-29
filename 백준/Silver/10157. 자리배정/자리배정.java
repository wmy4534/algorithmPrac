import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[R][C];
		if(K > C*R) {
			System.out.println(0);
			return;
		}
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int currentX = 0;
		int currentY = R - 1;
		int dIdx = 0;
		for (int i = 0; i < C * R; i++) {
			map[currentY][currentX] = i + 1;
			if (K == i + 1)
				break;
			if (currentX + dc[dIdx] >= 0 && currentX + dc[dIdx] < C && currentY + dr[dIdx] >= 0
					&& currentY + dr[dIdx] < R && map[currentY + dr[dIdx]][currentX + dc[dIdx]] == 0) {
				currentX += dc[dIdx];
				currentY += dr[dIdx];
			} else {
				dIdx += 1;
				dIdx %= 4;
				currentX += dc[dIdx];
				currentY += dr[dIdx];
			}
		}
		int targetX = currentX + 1;
		int targetY = R - currentY;
		System.out.println(targetX + " " + targetY);

	}
}