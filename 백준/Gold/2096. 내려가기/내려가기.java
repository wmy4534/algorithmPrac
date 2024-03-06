import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][][] map = new int[n+1][3][2]; // 0은 최대 1은 최소
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                int[][] previousNum = new int[3][2];
                int idx = 0;
                for (int k = 0; k < 3; k++) {
                    if (Math.abs(k-j) < 2) {
                        previousNum[idx][0] = map[i-1][k][0];
                        previousNum[idx++][1] = map[i-1][k][1];
                    }
                }
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int id = 0; id < idx; id++) {
                    if (previousNum[id][0] > max) {
                        max = previousNum[id][0];
                    }
                    if (previousNum[id][1] < min) {
                        min = previousNum[id][1];
                    }
                }
                map[i][j][0] = num + max;
                map[i][j][1] = num + min;
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (max < map[n][i][0]) {
                max = map[n][i][0];
            }
            if (min > map[n][i][1]) {
                min = map[n][i][1];
            }
        }
        System.out.print(max + " " + min);
    }
}