import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight = sc.nextInt();

        int q = weight/5;
        int r = weight%5;
        int num = q;
        for (int i=0; i<=q; i++) {
            if (r % 3 != 0) {
                num--;
                r += 5;
            }
            else {
                num += r/3;
                break;
            }
        }
        if (num==0) {
            num = -1;
        }
        System.out.println(num);


    }
}