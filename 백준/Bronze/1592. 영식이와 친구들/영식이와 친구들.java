import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람 수
        int M = sc.nextInt(); // Max 공 받는 횟수
        int L = sc.nextInt(); // 공을 던지는 간격

        int count = 0; // 공을 총 던진 횟수
        int[] countArr = new int[N]; // 사람당 공을 받은 횟수
        int nowIdx = 0; // 공을 가진 사람의 인덱스
        while(true) {
            countArr[nowIdx]++;
            if (countArr[nowIdx] == M)
                break;
            if (countArr[nowIdx]%2==0) {
                if ((nowIdx-L)<0) {
                    nowIdx = N + (nowIdx - L);
                    count++;
                }
                else {
                    nowIdx = nowIdx - L;
                    count++;
                }
            } else {
                nowIdx = (nowIdx+L)%N;
                count++;
            }

        }
        System.out.println(count);

    }
}