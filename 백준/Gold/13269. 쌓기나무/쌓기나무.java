import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		boolean[][] map = new boolean[N][M];
		int[] front = new int[M];
		int[] right = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().equals("1");
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			front[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			right[i] = Integer.parseInt(st.nextToken());
		}
		// 기본 세팅

		int[][] cntMap = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c])
					cntMap[r][c] = front[c];
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				int num = right[N - 1 - r];
				if (map[r][c] && cntMap[r][c] > num) {
					cntMap[r][c] = num;
				}
			}
		}

		boolean isPossible = true;
		for (int c = 0; c < M; c++) {
			int maxNum = 0;
			for (int r = 0; r < N; r++) {
				if (cntMap[r][c] > maxNum)
					maxNum = cntMap[r][c];
			}
			if (maxNum != front[c]) {
				isPossible = false;
				break;
			}
		}

		for (int r = 0; r < N; r++) {
			int maxNum = 0;
			for (int c = 0; c < M; c++) {
				if (cntMap[r][c] > maxNum)
					maxNum = cntMap[r][c];
			}
			if (maxNum != right[N - 1 - r]) {
				isPossible = false;
				break;
			}
		}

		if (isPossible) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					sb.append(cntMap[r][c]).append(" ");
				}
				sb.append("\n");
			}
		} else {
			sb.append(-1);
		}
		System.out.println(sb);
	}
}