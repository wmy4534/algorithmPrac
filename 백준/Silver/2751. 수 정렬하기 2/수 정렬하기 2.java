import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int[] negativeArr = new int[1000001];
        int[] positiveArr = new int[1000001];
        for (int i = 0; i < tc; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0) {
                negativeArr[Math.abs(num)]++;
            } else {
                positiveArr[num]++;
            }
        }
        for (int i = 1000000; i > 0; i--) {
            if (negativeArr[i] != 0) {
                sb.append(-i).append("\n");
            }
        }
        for (int i = 0; i < 1000001; i++) {
            if (positiveArr[i] != 0) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);


    }
}