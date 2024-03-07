import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[100001];
        for (int i = 0; i <= N; i++) {
            arr[N-i] = i;
        }
        for (int i = N+1; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i-1]+1, arr[i/2]);
            } else {
                arr[i] = arr[i-1]+1;
            }
            if (arr[i-1] > arr[i]+1) {
                arr[i-1] = arr[i]+1;
            }
        }
        System.out.println(arr[K]);
    }
}