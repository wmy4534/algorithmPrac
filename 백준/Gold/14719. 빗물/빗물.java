import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int height = Integer.parseInt(st.nextToken());
			for (int h = H - 1; h >= H - height; h--) {
				map[h][i] = true;
			}
		}
		int sum = 0;
		for (int r = 0; r < H; r++) {
			boolean check = false;
			int count = 0;
			for (int c = 0; c < W; c++) {
				if (map[r][c]) {
					check = true;
					sum += count;
					count = 0;
					continue;
				}
				if (check) {
					count++;
				}
			}
		}
		System.out.print(sum);
	}
}