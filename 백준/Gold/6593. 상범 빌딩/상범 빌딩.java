import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main {
    static boolean[][][] map;
    static boolean[][][] visited;
    static int[] start;
    static int[] goal;
    static int L;
    static int R;
    static int C;
    static int[] dl = {-1, 1, 0, 0, 0, 0}; // 상 하 동 서 남 북
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0)
                break;
            map = new boolean[L][R][C];
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < C; c++) {
                        if (line.charAt(c) == '.') {
                            map[l][r][c] = true;
                        } else if (line.charAt(c) == 'S') {
                            map[l][r][c] = true;
                            start = new int[]{l, r, c};
                        } else if (line.charAt(c) == 'E') {
                            map[l][r][c] = true;
                            goal = new int[]{l, r, c};
                        }
                    }
                }
                br.readLine();
            }
            int time = bfs();
            if (time >= 0)
                sb.append("Escaped in ").append(time).append(" minute(s).\n");
            else
                sb.append("Trapped!\n");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        int time = 0;
        visited = new boolean[L][R][C];
        boolean isEscape = false;
        Queue<int[]> queue = new ArrayDeque<>();
        int[] tmp = new int[4];
        for (int i = 0; i < 3; i++) {
            tmp[i] = start[i];
        }
        queue.offer(tmp);
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nl = tmp[0] + dl[i];
                int nr = tmp[1] + dr[i];
                int nc = tmp[2] + dc[i];
                if (nl == goal[0] && nr == goal[1] && nc == goal[2]) {
                    isEscape = true;
                    time = tmp[3]+1;
                    break;
                }
                if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nl][nr][nc] && map[nl][nr][nc]) {
                    queue.offer(new int[] {nl, nr, nc, tmp[3]+1});
                    visited[nl][nr][nc] = true;
                }
            }
        }
        return isEscape ? time : -1;
    }
}