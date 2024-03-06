import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] alphabet = new boolean[26]; // '알파벳 대문자' - 'A'를 인덱스로 가지는 배열
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int moveCnt = 0;
    static int maxMove = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                board[r][c] = str.charAt(c)-'A';
            }
        }
        dfs(0, 0);
        System.out.println(maxMove);
    }

    private static void dfs(int r, int c) {

        alphabet[board[r][c]] = true;
        moveCnt++;
        if (moveCnt > maxMove)
            maxMove = moveCnt;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && !alphabet[board[nr][nc]])
                dfs(nr, nc);
        }
        alphabet[board[r][c]] = false;
        moveCnt--;
    }
}