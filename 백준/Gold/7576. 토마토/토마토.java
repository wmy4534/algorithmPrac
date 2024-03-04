import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] box; // 토마토가 있는 박스
    static List<Integer[]> ripedTomato = new ArrayList<>(); // 익은 토마토 위치
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int day = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                box[r][c] = Integer.parseInt(st.nextToken());
                if (box[r][c] == 1) {
                    Integer[] tmp = new Integer[] {r, c};
                    ripedTomato.add(tmp);
                }
            }
        }
        ripe();
        day--;
        Loop: for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 0) {
                    day = -1;
                    break Loop;
                }
            }
        }
        System.out.print(day);
    }

    private static void ripe() {
        Queue<Integer[]> queue = new LinkedList<>();
        for (Integer[] tomato : ripedTomato) {
            queue.offer(tomato);
        }
        while (!queue.isEmpty()) {
            int repeat = queue.size();

            for (int i = 0; i < repeat; i++) {
                Integer[] tmp = queue.poll();
                int nr = tmp[0];
                int nc = tmp[1];

                for (int j = 0; j < 4; j++) {
                    int nextR = nr + dr[j];
                    int nextC = nc + dc[j];

                    if (nextR >= 0 && nextR < box.length && nextC >= 0 && nextC < box[0].length && box[nextR][nextC] == 0) {
                        box[nextR][nextC] = 1;
                        queue.offer(new Integer[] {nextR, nextC});
                    }
                }
            }
            day++;
        }
    }
}