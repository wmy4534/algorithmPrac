import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int dayUp = (up-down);
        if ( (target-up)%dayUp==0) {
            sb.append((target-up)/dayUp+1);
            // System.out.println((target-up)/dayUp+1);
        }
        else
            sb.append((target-up)/dayUp+2);
            // System.out.println((target-up)/dayUp+2);
        System.out.println(sb);
    }
}