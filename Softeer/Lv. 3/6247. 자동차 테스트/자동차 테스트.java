import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int midValue = Integer.parseInt(br.readLine());
            if (map.containsKey(midValue)) {
                int idx = map.get(midValue);
                int result = idx * (n-1-idx);
                sb.append(result).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
        
    }
}
