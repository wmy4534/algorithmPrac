import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int actionNum = Integer.parseInt(br.readLine());
        String actions = br.readLine();

        int curR = 50;
        int curC = 50;

        boolean[][] map = new boolean[101][101]; // 최대 길이가 50이기 때문에 100까지 설정
        map[curR][curC] = true;
        // 방향(남 서 북 동)
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, -1, 0, 1};
        int idx = 0;
        int minR = curR;
        int maxR = curR;
        int minC = curC;
        int maxC = curC;
        for (int i = 0; i < actionNum; i++) {
            char action = actions.charAt(i);
            if (action == 'F') {
                curR += dr[idx];
                curC += dc[idx];
                map[curR][curC] = true;
                maxR = Math.max(maxR, curR);
                minR = Math.min(minR, curR);
                maxC = Math.max(maxC, curC);
                minC = Math.min(minC, curC);
            } else if (action == 'R') {
                idx = (idx+1)%4;
            } else {
                idx = (idx+3)%4;
            }
        }
        for (int r = minR; r <= maxR; r++) {
            for (int c = minC; c <= maxC; c++) {
                if (map[r][c]) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}