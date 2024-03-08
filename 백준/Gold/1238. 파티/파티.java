import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        Integer[][] time = new Integer[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            time[r][c] = T;
        }
        Integer[] toX = new Integer[N+1];
        Integer[] fromX = new Integer[N+1];
        Queue<Integer> queue = new LinkedList<>();
        int start = X;
        toX[start] = 0;
        fromX[start] = 0;
        for (int i = 1; i <= N; i++) {
            if (time[i][start] != null) {
                toX[i] = time[i][start];
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                start = queue.poll();
                for (int j = 1; j <= N; j++) {
                    if (time[j][start] != null) { // 도로가 있음
                        if (toX[j] == null) { // 한 번도 들린 적 없음
                            toX[j] = toX[start] + time[j][start];
                            queue.offer(j);
                        } else { // 전에 들른 적 있음
                            if (toX[j] > toX[start] + time[j][start]) {
                                toX[j] = toX[start] + time[j][start];
                                queue.offer(j);
                            }
                        }
                    }
                }

            }
        }
        start = X;
        for (int i = 1; i <= N; i++) {
            if (time[start][i] != null) {
                fromX[i] = time[start][i];
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                start = queue.poll();
                for (int j = 1; j <= N; j++) {
                    if (time[start][j] != null) {
                        if (fromX[j] == null) {
                            fromX[j] = fromX[start] + time[start][j];
                            queue.offer(j);
                        } else {
                            if (fromX[j] > fromX[start] + time[start][j]) {
                                fromX[j] = fromX[start] + time[start][j];
                                queue.offer(j);
                            }
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, toX[i] + fromX[i]);
        }
        System.out.print(max);

    }
}