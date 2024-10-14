import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];
        List<int[]>[][] roads = new ArrayList[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                roads[i][j] = new ArrayList<>();
            }
        }

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            if (r1 == r2) {
                if (c1 > c2) { // c1이 c2보다 오른쪽에 있음 0 1 2 3 == 상 하 좌 우
                    map[r1][c1] |= 2 << 2; // 왼쪽에 길이 있음
                    map[r2][c2] |= 2 << 3; // 오른쪽에 길이 있음
                } else {
                    map[r1][c1] |= 2 << 3; // 오른쪽에 길이 있음
                    map[r2][c2] |= 2 << 2; // 왼쪽에 길이 있음
                }
            } else if (c1 == c2) {
                if (r1 > r2) { // r1이 r2보다 아래에 있음
                    map[r1][c1] |= 2 << 0; // 위에 길이 있음
                    map[r2][c2] |= 2 << 1; // 아래에 길이 있음
                } else {
                    map[r1][c1] |= 2 << 1;
                    map[r2][c2] |= 2 << 0;
                }
            }
        }

        int[][] cows = new int[K][2];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cows[k][0] = r;
            cows[k][1] = c;
            map[r][c] |= 1;
        }
        int answer = 0;
        for (int i = 0; i < K; i++) {
            boolean[][] visited = new boolean[N + 1][N + 1];
            visited[cows[i][0]][cows[i][1]] = true;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(cows[i]);
            int num = 1;
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                int r = tmp[0];
                int c = tmp[1];
                for (int idx = 0; idx < 4; idx++) {
                    int nr = r + dr[idx];
                    int nc = c + dc[idx];
                    if (nr > 0 && nr <= N && nc > 0 && nc <= N && !visited[nr][nc] && (map[r][c] & (2 << idx)) == 0) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                        if ((map[nr][nc] & 1) == 1) {
                            num++;
                        }
                    }
                }
            }
            answer += K - num;
        }
        System.out.println(answer / 2);
    }
}
