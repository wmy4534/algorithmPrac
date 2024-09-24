import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        int digitNum = 1; // 자릿 수
        long start = 0; // 시작하는 수
        long cnt = 0;
        while (start < k) {
            long n = start * 10 + 9;
            long tmp = cnt + (digitNum * (n - start));
            if (tmp < k) {
                cnt = tmp;
                start = n;
            }
            else break;
            digitNum++;
        }
        long move = k - cnt;
        long num = (long) (start + Math.ceil((double) move / digitNum));
        if (num > N) {
            System.out.println(-1);
        } else {
            long rest = move % digitNum;
            rest += digitNum - 1;
            rest %= digitNum;
            System.out.println(Long.toString(num).charAt((int) rest));
        }
    }
}
