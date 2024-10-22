import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map, roomMap;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1}; // 서 북 동 남
    static int[] dc = {-1, 0, 1, 0};
    static int roomCnt, maxArea, roomNum;
    static Map<Integer, Integer> areas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        roomMap = new int[N][M];
        visited = new boolean[N][M];
        areas = new HashMap<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        roomCnt = 0;
        maxArea = 0;
        roomNum = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c]) {
                    roomCnt++;
                    roomNum++;
                    bfs(r, c);
                }
            }
        }
        int afterMaxArea = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && roomMap[r][c] != roomMap[nr][nc]) {
                        int areaSum = areas.get(roomMap[r][c]) + areas.get(roomMap[nr][nc]);
                        if (afterMaxArea < areaSum)
                            afterMaxArea = areaSum;
                    }
                }
            }
        }
        System.out.println(roomCnt + "\n" + maxArea + "\n" + afterMaxArea);
    }

    static private void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        int area = 0;
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            roomMap[tmp[0]][tmp[1]] = roomNum;
            area++;
            for (int i = 0; i < 4; i++) {
                int nr = tmp[0] + dr[i];
                int nc = tmp[1] + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && (map[tmp[0]][tmp[1]] & (1 << i)) == 0) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }

            }
        }
        areas.put(roomNum, area);
        if (maxArea < area) {
            maxArea = area;
        }
    }
}
