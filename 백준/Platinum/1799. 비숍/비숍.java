import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static int N;
	static int[][] board;
	static int maxBlack = 0, maxWhite = 0;
	static boolean[] leftDiag, rightDiag; // 대각선 검사

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		leftDiag = new boolean[2 * N - 1];
		rightDiag = new boolean[2 * N - 1];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				board[r][c] = st.nextToken().equals("1") ? 0 : -1; // 0이면 배치 가능
			}
		}

		dfs(0, 0, true);
		dfs(0, 0, false);
		System.out.println(maxBlack + maxWhite);
	}

	private static void dfs(int point, int count, boolean isBlack) {
		if (isBlack) {
			maxBlack = Math.max(maxBlack, count);
		} else {
			maxWhite = Math.max(maxWhite, count);
		}

		for (int p = point; p < N * N; p++) {
			int r = p / N;
			int c = p % N;
			if ((r + c) % 2 == 0 != isBlack || board[r][c] < 0)
				continue;

			int leftDiagIdx = c - r + N - 1;
			int rightDiagIdx = r + c;
			if (leftDiag[leftDiagIdx] || rightDiag[rightDiagIdx])
				continue;

			leftDiag[leftDiagIdx] = true;
			rightDiag[rightDiagIdx] = true;
			board[r][c] = 1;

			dfs(r * N + c + 1, count + 1, isBlack);

			leftDiag[leftDiagIdx] = false;
			rightDiag[rightDiagIdx] = false;
			board[r][c] = 0;
		}
	}
}
