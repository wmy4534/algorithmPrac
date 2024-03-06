import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] RGB = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                int[] pn = new int[2];
                int idx = 0;
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        pn[idx++] = RGB[i-1][k];
                    }
                }
                RGB[i][j] = num + Math.min(pn[0], pn[1]);
            }
        }
        int min = RGB[N][0];
        for (int i = 1; i < 3; i++) {
            if (min > RGB[N][i])
                min = RGB[N][i];
        }
        System.out.println(min);
    }
}