import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr = new int[100001][2]; // 0번 인덱스는 최소 시간 1번 인덱스는 전 숫자
        arr[N][0] = 0;
        arr[N][1] = N;
        for (int i = 1; i <= N; i++) {
            arr[N-i][0] = i;
            arr[N-i][1] = N-i+1;
        }
        for (int i = N+1; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i - 1][0] < arr[i / 2][0]) {
                    arr[i][0] = arr[i - 1][0] + 1;
                    arr[i][1] = i-1;
                } else {
                    arr[i][0] = arr[i / 2][0] + 1;
                    arr[i][1] = i / 2;
                }
            } else {
                arr[i][0] = arr[i - 1][0] + 1;
                arr[i][1] = i - 1;
            }
            if (arr[i][0]+1 < arr[i - 1][0]) {
                arr[i - 1][0] = arr[i][0] + 1;
                arr[i - 1][1] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr[K][0]).append("\n");
        int[] reverse = new int[arr[K][0]+1];
        int idx = 0;
        reverse[idx++] = K;
        int num = K;
        while (num != N) {
            num = arr[num][1];
            reverse[idx++] = num;
        }
        for (int i = idx-1; i >= 0; i--) {
            sb.append(reverse[i]).append(" ");
        }
        System.out.print(sb);
    }
}