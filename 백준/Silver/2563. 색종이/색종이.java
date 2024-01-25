import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][] map = new int[100][100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			getColored(map, x, y);
		}
		int area = 0;
		for(int r = 0; r < 100; r++) {
			for(int c = 0; c < 100; c++) {
				if (map[r][c] == 1)
					area++;
			}
		}
		System.out.println(area);
		
	}
	
	public static void getColored(int[][] map, int x, int y) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				map[x+i][y+j] = 1;
			}
		}
	}

}