import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m]; // 0은 통과 가능, 1은 벽, 2는 목적지
        List<int[]> ghosts = new ArrayList<>();
        int[] nowLoc = new int[2]; // 0번은 r, 1번은 c
        int[] goal = new int[2];
        for (int r = 0; r < n; r++) {
            String str = br.readLine();
            for (int c = 0; c < m; c++) {
                char tmp = str.charAt(c);
                if (tmp == 'D') {
                    map[r][c] = 2;
                    goal[0] = r;
                    goal[1] = c;
                } else if (tmp == '#') {
                    map[r][c] = 1;
                } else if (tmp == 'G') {
                    ghosts.add(new int[] {r, c});
                } else if (tmp == 'N') {
                    nowLoc[0] = r;
                    nowLoc[1] = c;
                }
            }
        }

        int moveCnt = 0;
        int goalCnt = -1;
        int[] dr = {-1, 1, 0 ,0};
        int[] dc = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(nowLoc);
        Loop: while (!queue.isEmpty()) {
            int size = queue.size();
            moveCnt++;
            for (int i = 0; i < size; i++) {
                int[] loc = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = loc[0] + dr[j];
                    int nc = loc[1] + dc[j];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != 1) {
                        if (map[nr][nc] == 2) {
                            goalCnt = moveCnt;
                            break Loop;
                        }
                        queue.offer(new int[] {nr, nc});
                        map[nr][nc] = 1;
                    }
                }
            }
        }
        if (goalCnt >= 0) {
            for (int i = 0; i < ghosts.size(); i++) {
                int dist = Math.abs(ghosts.get(i)[0] - goal[0]) + Math.abs(ghosts.get(i)[1] - goal[1]);
                if (goalCnt >= dist) {
                    goalCnt = -1;
                    break;
                }
            }
        }
        if (goalCnt >= 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
