import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 연병장의 크기
        int M = Integer.parseInt(st.nextToken()); // 조교의 수
        int[] map = new int[N + 1]; // 1번 칸부터 연병장
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Integer[][] arr1 = new Integer[M][2];
        Integer[][] arr2 = new Integer[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr1[i][0] = a;
            arr1[i][1] = k;
            arr2[i][0] = b;
            arr2[i][1] = k;
        }
        Arrays.sort(arr1, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(arr2, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = 0;
        int end = 0;
        int preSum = 0;
        for (int i = 1; i <= N; i++) {
            for (; start < M; start++) {
                if (arr1[start][0] <= i && arr2[start][0] >= i)
                    preSum += arr1[start][1];
                else
                    break;
            }
            for (; end < M; end++) {
                if (arr2[end][0] < i)
                    preSum -= arr2[end][1];
                else
                    break;
            }
            map[i] += preSum;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(map[i]).append(" ");
        }
        System.out.print(sb);
    }
}