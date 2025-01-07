import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] colors = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;

        for (int start = 0; start < 3; start++) {
            int[][] homes = new int[N][3];

            for (int i = 0; i < N; i++) {
                Arrays.fill(homes[i], 1000001);
            }
            homes[0][start] = colors[0][start];

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (j == k) continue;
                        homes[i][j] = Math.min(homes[i][j], colors[i][j] + homes[i - 1][k]);
                    }
                }
            }

            for (int j = 0; j < 3; j++) {
                if (j != start) {
                    result = Math.min(result, homes[N - 1][j]);
                }
            }
        }

        System.out.println(result);
    }
}
