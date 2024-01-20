import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		//int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			//int N = sc.nextInt();
			//int M = sc.nextInt();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			///// 입력 끝
			int max = 0;
			for (int r = 0; r < N-M+1; r++) {
				for (int c = 0; c < N-M+1; c++) {
					int sum = 0;
					for (int j = r; j < r+M; j++) {
						for (int k = c; k < c+M; k++) {
							sum += arr[j][k];
						}
					}
					if (sum > max) {
						max = sum;
					}
				}
			}
			//System.out.println("#"+i+" "+max);
			sb.append("#"+i+" "+max+"\n");
		}
		System.out.println(sb);
	}
}