import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dice {
    int[] dice = new int[6];
    int[] dx = {0, 0, -1, 1}; // 1, 2, 3, 4 순서에 맞춰서 동서북남
    int[] dy = {1, -1, 0, 0};
    int x, y;

    Dice(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int cmd) {
        x += dx[cmd - 1];
        y += dy[cmd - 1];
    }

    public void roll(int cmd) {
        int temp;
        switch (cmd) {
            case 1: // 동쪽
                temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 2: // 서쪽
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
            case 3: // 북쪽
                temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
            case 4: // 남쪽
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
        }
    }

    public int getTop() {
        return dice[0];
    }

    public void setTop(int top) {
        dice[0] = top;
    }

    public int getValue() {
        return dice[5];
    }

    public void setValue(int value) {
        dice[5] = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(x, y);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            int nx = dice.x + dice.dx[cmd - 1];
            int ny = dice.y + dice.dy[cmd - 1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;

            dice.move(cmd);
            dice.roll(cmd);

            if (map[nx][ny] == 0) { // 이동한 칸이 0인 경우
                map[nx][ny] = dice.getValue(); // 주사위 바닥에 복사
            } else { // 이동한 칸이 0이 아닌 경우
                dice.setValue(map[nx][ny]); // 주사위 바닥에 설정
                map[nx][ny] = 0;
            }

            sb.append(dice.getTop()).append("\n");
        }
        System.out.print(sb);
    }
}