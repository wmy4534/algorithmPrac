import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static Deque<int[]> dq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dq = new ArrayDeque<>();
        int[] canSee = new int[N + 1];
        int[] shortSee = new int[N + 1];
        int height = 0;

        // 왼쪽에서 오른쪽으로 보는 경우
        for (int i = 1; i <= N; i++) {
            height = arr[i];
            while (!dq.isEmpty() && dq.peekFirst()[1] <= height) {
                dq.pollFirst();
            }
            canSee[i] += dq.size();
            if (!dq.isEmpty()) {
                shortSee[i] = dq.peekFirst()[0];
            }
            dq.offerFirst(new int[] { i, height });
        }

        // Deque 초기화
        dq.clear();

        // 오른쪽에서 왼쪽으로 보는 경우
        for (int i = N; i > 0; i--) {
            height = arr[i];
            while (!dq.isEmpty() && dq.peekFirst()[1] <= height) {
                dq.pollFirst();
            }
            canSee[i] += dq.size();
            if (!dq.isEmpty()) {
                if (shortSee[i] == 0 || Math.abs(i - shortSee[i]) > Math.abs(dq.peekFirst()[0] - i)) {
                    shortSee[i] = dq.peekFirst()[0];
                }
            }
            dq.offerFirst(new int[] { i, height });
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            if (canSee[i] == 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(canSee[i]).append(" ").append(shortSee[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
