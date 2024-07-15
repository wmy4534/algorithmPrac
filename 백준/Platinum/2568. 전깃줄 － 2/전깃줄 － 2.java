import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<Integer> list = new ArrayList<>(); // 위치에 넣기
        int[] arr = new int[N]; // 몇 번인가?
        list.add(map[0][1]);
        arr[0] = 1;
        for (int i = 0; i < N; i++) {
            int[] tmp = map[i];
            int idx = Collections.binarySearch(list, tmp[1]);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx >= list.size()) {
                list.add(tmp[1]);
            } else {
                list.set(idx, tmp[1]);
            }
            arr[i] = idx;
        }
        int num = list.size();
        StringBuilder sb = new StringBuilder();
        sb.append(N - num).append("\n");
        Set<Integer> set = new HashSet<>();
        for (int i = N-1; i >= 0; i--) {
            if (arr[i]+1 == num) {
                set.add(map[i][0]);
                num--;
                if (num == 0)
                    break;
            }
        }
        for (int[] tmp : map) {
            if (!set.contains(tmp[0]))
                sb.append(tmp[0]).append("\n");
        }
        System.out.print(sb);
    }
}