import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {0, 0, 0, -1, 1}; // 제자리, 우, 좌, 상, 하
    static int[] dc = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 체스판의 크기
        int K = Integer.parseInt(st.nextToken()); // 말의 개수
        int[][] board = new int[N][N];

        // 체스판 색깔 정보 입력
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 체스판 위의 말 위치를 저장할 맵(Deque 배열)
        Deque<Integer>[][] map = new ArrayDeque[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = new ArrayDeque<>();
            }
        }

        // 각 체스말의 위치 및 방향 정보 저장
        int[][] chess_piece = new int[K][2]; // 체스말의 위치와 방향 (위치: r * N + c, 방향: 1~4)

        // 체스말 정보 입력
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            chess_piece[k][0] = r * N + c;
            chess_piece[k][1] = d;
            map[r][c].offerLast(k);
        }

        int count = 0;
        int answer = -1;

        complete:
        while (count <= 1000) {
            count++;
            for (int k = 0; k < K; k++) { // 각 말에 대해 턴을 진행
                int locate = chess_piece[k][0];
                int direction = chess_piece[k][1];
                int r = locate / N;
                int c = locate % N;
                int nr = r + dr[direction];
                int nc = c + dc[direction];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) { // 보드 범위 안에 있을 때
                    switch (board[nr][nc]) {
                        case 0: // 흰색 칸
                            movePieces(map, chess_piece, r, c, nr, nc, k, false, N);
                            break;
                        case 1: // 빨간색 칸
                            movePieces(map, chess_piece, r, c, nr, nc, k, true, N);
                            break;
                        case 2: // 파란색 칸
                            direction = reverseDirection(direction);
                            chess_piece[k][1] = direction;
                            nr = r + dr[direction];
                            nc = c + dc[direction];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] != 2) {
                                k--;
                            } else if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 2) {
                                continue;
                            }
                            break;
                        default:
                            System.out.println("이건 있으면 안됩니다");
                            break;
                    }
                } else { // 보드 밖으로 나가는 경우
                    direction = reverseDirection(direction);
                    chess_piece[k][1] = direction;
                    nr = r + dr[direction];
                    nc = c + dc[direction];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] != 2) {
                        k--;
                    } else if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 2) {
                        continue;
                    }
                }

                // 말이 4개 이상 쌓이면 게임 종료
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc].size() >= 4) {
                    answer = count;
                    break complete;
                }
            }
        }

        System.out.println(answer);
    }

    // 체스말 이동을 처리하는 함수
    private static void movePieces(Deque<Integer>[][] map, int[][] chess_piece, int r, int c, int nr, int nc, int k, boolean reverse, int N) {
        Deque<Integer> dq = new ArrayDeque<>();

        // 현재 말이 움직일 때, 그 말 위의 말들을 이동
        while (!map[r][c].isEmpty() && map[r][c].peekLast() != k) {
            dq.offerLast(map[r][c].pollLast());
        }
        dq.offerLast(map[r][c].pollLast());

        // 빨간색 칸이면 순서 반대로 이동
        if (!reverse) {
            while (!dq.isEmpty()) {
                int num = dq.pollLast();
                chess_piece[num][0] = nr * N + nc;
                map[nr][nc].offerLast(num);
            }
        } else { // 흰색 칸이면 그대로 이동
            while (!dq.isEmpty()) {
                int num = dq.pollFirst();
                chess_piece[num][0] = nr * N + nc;
                map[nr][nc].offerLast(num);
            }
        }
    }

    // 방향을 반대로 바꾸는 함수 (1 <-> 2, 3 <-> 4)
    private static int reverseDirection(int direction) {
        return (direction % 2 == 0) ? direction - 1 : direction + 1;
    }
}
