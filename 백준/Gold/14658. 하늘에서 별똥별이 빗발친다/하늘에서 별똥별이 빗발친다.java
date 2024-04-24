import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 지도 가로 길이
		int M = Integer.parseInt(st.nextToken()); // 지도 세로 길이
		int L = Integer.parseInt(st.nextToken()); // 트램펄린 한 변의 길이
		int K = Integer.parseInt(st.nextToken()); // 별똥별의 수
		
		int[][] stars = new int[K][2]; 
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			stars[i][0] = x;
			stars[i][1] = y;
		}
		
		int max = 0; // 가장 많이 튕겨나간 별똥별의 수
		for (int i = 0; i < K; i++) { // 별똥별 좌표들
			for (int j = 0; j < K; j++) {
				int x = Math.min(stars[i][0], stars[j][0]);
				int y = Math.min(stars[i][1], stars[j][1]);
				int cnt = 0;
				for (int k = 0; k < K; k++) {
					if (stars[k][0] >= x && stars[k][0] - x <= L && stars[k][1] >= y && stars[k][1] - y <= L)
						cnt++;
				}
				if (cnt > max)
					max = cnt;
			}
		}
		System.out.print(K - max);
	}
}