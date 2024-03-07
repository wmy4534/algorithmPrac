import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr = new int[100001][2]; // 0번 인덱스는 최소 시간, 1번 인덱스는 가는 방법 수
        for (int i = 0; i <= N; i++) {
            arr[N-i][0] = i;
            arr[N-i][1] = 1;
        }
        for (int i = N+1; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i - 1][0] < arr[i / 2][0]) {
                    arr[i][0] = arr[i - 1][0] + 1;
                    arr[i][1] = arr[i - 1][1];
                } else if (arr[i - 1][0] > arr[i / 2][0]) {
                    arr[i][0] = arr[i / 2][0] + 1;
                    arr[i][1] = arr[i / 2][1];
                } else {
                    arr[i][0] = arr[i - 1][0] + 1;
                    arr[i][1] = arr[i - 1][1] + arr[i / 2][1];
                }
            } else {
                arr[i][0] = arr[i-1][0]+1;
                arr[i][1] = arr[i-1][1];
            }
            if (arr[i-1][0] > arr[i][0]+1) {
                arr[i-1][0] = arr[i][0]+1;
                arr[i-1][1] = arr[i][1];
            } else if (arr[i-1][0] == arr[i][0]+1) {
                arr[i-1][1] += arr[i][1];
            }
        }
        System.out.println(arr[K][0]);
        System.out.println(arr[K][1]);
    }
}