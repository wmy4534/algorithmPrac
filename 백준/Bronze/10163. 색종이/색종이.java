import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int paperNum = Integer.parseInt(br.readLine()); // 색종이 개수 입력
        int[][] map = new int[1001][1001]; // 전체 평면의 크기
        for (int n = 1; n <= paperNum; n++) { // 색종이 좌표, 크기 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            for (int c = x; c < x+width; c++) {
                for (int r = 1000-y; r > 1000-(y+height); r--) {
                    map[r][c] = n;
                }
            }
        }
        int[] papers = new int[paperNum];
        for(int r = 0; r < 1001; r++) {
            for(int c = 0; c < 1001; c++) {
                if(map[r][c] != 0) {
                    papers[map[r][c] - 1]++;
                }
            }
        }
        for(int i = 0; i < papers.length; i++) {
            sb.append(papers[i]+"\n");
        }
        System.out.println(sb);
    }
}