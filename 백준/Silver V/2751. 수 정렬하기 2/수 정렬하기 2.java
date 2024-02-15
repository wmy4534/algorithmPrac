import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int[] countArr = new int[2000001];
        for (int i = 0; i < tc; i++) {
            int num = Integer.parseInt(br.readLine());
            countArr[num+1000000]++;
        }
        for (int i = 0; i < 2000001; i++) {
            if (countArr[i] != 0)
                sb.append(i-1000000).append("\n");
        }
        System.out.println(sb);
    }
}