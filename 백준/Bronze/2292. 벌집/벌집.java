import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int num = 2;
        if (target < num)
            System.out.println(1);
        else {
            for (int i = 0; ; i++) {
                if (num > target) {
                    System.out.println(i);
                    break;
                }
                num += 6 * i;
            }
        }
    }
}