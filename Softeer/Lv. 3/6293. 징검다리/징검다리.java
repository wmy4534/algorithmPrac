import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] bridge = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[N];
        count[N-1] = 1;
        for (int i = N-2; i >= 0; i--) { // 뒤에서부터 개수 시작
            int start = bridge[i];
            int max = 0;
            for (int j = i+1; j < N; j++) { // 바로 뒤에 징검다리들과 비교 시작
                if (bridge[j] > start && count[j] > max) {
                    max = count[j];
                }
            }
            count[i] = 1 + max;
        }
        int maxCnt = 0;
        for (int i = 0; i < N; i++) {
            if (count[i] > maxCnt)
                maxCnt = count[i];
        }
        System.out.print(maxCnt);
    }
}
