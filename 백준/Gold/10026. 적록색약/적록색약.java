import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for(int n = 0; n < N; n++) {
            String str = br.readLine();
            map[n] = str.toCharArray();
        }
        char[][] weekColor = map;
        visit = new boolean[N][N];
        int count = 0;
        for(int r = 0; r < N; r++) {
            for (int c = 0; c <N; c++) {
                if(!visit[r][c]) {
                    moveAlong(map, r, c);
                    count++;
                }
                if (map[r][c] == 'G')
                    weekColor[r][c] = 'R';
            }
        }
        sb.append(count).append(" ");
        visit = new boolean[N][N];
        count = 0;
        for(int r = 0; r < N; r++) {
            for (int c = 0; c <N; c++) {
                if(!visit[r][c]) {
                    moveAlong(weekColor, r, c);
                    count++;
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
    private static void moveAlong(char[][] map, int r, int c) {
//        System.out.println(r+", "+c);
        visit[r][c] = true;
        if(r >= map.length || c >= map.length)
            return;

        if (r+1 < N && map[r][c] == map[r+1][c] && !visit[r+1][c]) {
            moveAlong(map, r+1, c);
        }
        if (c+1 <N && map[r][c] == map[r][c+1] && !visit[r][c+1]) {
            moveAlong(map, r, c+1);
        }
        if (c-1 >= 0 && map[r][c] == map[r][c-1] && !visit[r][c-1]) {
            moveAlong(map, r, c-1);
        }
        if (r-1 >= 0 && map[r][c] == map[r-1][c] && !visit[r-1][c]) {
            moveAlong(map,r-1, c);
        }

    }
}