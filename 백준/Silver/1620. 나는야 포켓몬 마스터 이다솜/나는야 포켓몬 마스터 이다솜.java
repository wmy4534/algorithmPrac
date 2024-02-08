import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] poketmonArr = new String[N];
        String[] tmp = new String[N];
        for (int i = 0; i < N; i++) {
            poketmonArr[i] = br.readLine();
            tmp[i] = poketmonArr[i] + " " + (i+1);
        }
        Arrays.sort(tmp);
        int[] firstCArr = new int[26];
        for (int i = 0; i < N; i++) {
            firstCArr[poketmonArr[i].charAt(0)-'A']++;
        }
        int[] prefixSum = new int[27];
        prefixSum[0] = 0;
        for (int i = 1; i < 27; i++) {
            prefixSum[i]= prefixSum[i-1]+firstCArr[i-1];
        }
        for (int m = 0; m < M; m++) {
            String input = br.readLine();
            if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
                sb.append(poketmonArr[Integer.parseInt(input)-1]).append("\n");
            } else {
                for (int i = prefixSum[input.charAt(0)-'A']; i < N; i++) {
                    if (tmp[i].contains(input)) {
                        String[] list = tmp[i].split(" ");
                        sb.append(list[1]).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}