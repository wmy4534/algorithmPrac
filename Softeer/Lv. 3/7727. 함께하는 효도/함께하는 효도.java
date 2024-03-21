import java.io.*;
import java.util.*;

public class Main {

    static int n; // 지도 넓이
    static int m; // 친구 숫자
    static int[][] map; // 전체 지도
    static int[][] friends; // 친구들 시작 위치
    static boolean[][] totalVisit; // 모든 친구들의 방문
    static int count = 0; // 몇 번 움직였나?
    static int sum = 0; // 총 열매 수확량
    static int maxSum = 0; // 최대 열매 수확량
    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1]; // 1번부터 시작
        totalVisit = new boolean[n+1][n+1];
        
        for (int r = 1; r <= n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        friends = new int[4][2]; // 0번은 r, 1번은 c
        for (int i = 0; i < m; i++) { // 친구 숫자만큼
            st = new StringTokenizer(br.readLine());
            friends[i][0] = Integer.parseInt(st.nextToken()); // 친구의 r 위치
            friends[i][1] = Integer.parseInt(st.nextToken()); // 친구의 c 위치
            totalVisit[friends[i][0]][friends[i][1]] = true;
            sum += map[friends[i][0]][friends[i][1]];
        }
        dfs(friends[0][0], friends[0][1]);
        System.out.print(maxSum);
    }
    
    private static void dfs(int r, int c) {
        if (count >= m*3) {
            if (maxSum < sum)
                maxSum = sum;
            return;
        }
        count++;
        for (int i = 0; i < 4; i++) { // dr, dc 인덱스
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 1 && nr <= n && nc >= 1 && nc <= n) {
                if (!totalVisit[nr][nc]) {
                    totalVisit[nr][nc] = true;
                    sum += map[nr][nc];
                    if (count % 3 != 0) {
                        dfs(nr, nc);
                    } else {
                        dfs(friends[count/3][0], friends[count/3][1]);
                    }
                    sum -= map[nr][nc];
                    totalVisit[nr][nc] = false;
                } else {
                    dfs(nr, nc);
                }
            }
        }
        count--;
    }
}
