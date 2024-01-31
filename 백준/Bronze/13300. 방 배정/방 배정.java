import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentNum = Integer.parseInt(st.nextToken()); // 학생 수
        int roomCapacity = Integer.parseInt(st.nextToken()); // 방 최대 수용 인원
        int[][] students = new int[2][7];
        for (int n = 0; n < studentNum; n++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            students[s][grade]++;
        }
        int roomCount = 0;
        for (int i = 0; i <= 1; i++) {
            for (int j = 1; j < 7; j++) {
                if (students[i][j] > 0) {
                    roomCount++;
                    if (students[i][j] / roomCapacity >= 1) {
                        roomCount += students[i][j]/roomCapacity;
                    }
                    if (students[i][j] % roomCapacity == 0)
                        roomCount--;
                }
            }
        }
        System.out.println(roomCount);
    }
}