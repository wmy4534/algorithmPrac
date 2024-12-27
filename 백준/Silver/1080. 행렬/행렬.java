import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] startArr = new char[N][M];
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < M; c++) {
				startArr[r][c] = line.charAt(c);
			}
		}
		boolean[][] arr = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < M; c++) {
				char ch = line.charAt(c);
				if (startArr[r][c] == ch) {
					arr[r][c] = true;
				}
			}
		}
		int answer = 0;
		for (int r = 0; r < N - 2; r++) {
			for (int c = 0; c < M - 2; c++) {
				if (arr[r][c]) {
					continue;
				}
				answer++;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						arr[r + i][c + j] = !arr[r + i][c + j];
					}
				}
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!arr[r][c]) {
					answer = -1;
				}
			}
		}
		System.out.println(answer);
	}
}
