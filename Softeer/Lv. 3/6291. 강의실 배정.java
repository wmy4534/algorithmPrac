import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lessons = new int[N][2]; // 0번 인덱스는 시작시간, 1번 인덱스는 끝나는 시간

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lessons[i][0] = Integer.parseInt(st.nextToken());
            lessons[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lessons, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        // 먼저 끝나는 순서대로, 그러나 인덱스는 큰 순서대로
        int start = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (lessons[i][0] >= end) {
                start = lessons[i][0];
                end = lessons[i][1];
                count++;
            }
        }
        System.out.print(count);
    }
}
