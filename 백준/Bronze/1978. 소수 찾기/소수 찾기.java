import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        int primeCount = 0;

        for (int i=0; i<caseNum; i++) {
            int num = sc.nextInt();
            boolean check = true;
            if (num > 1) {
                for(int j = 2; j < num; j++) {
                    if (num%j==0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    primeCount++;
                }
            }
        }
        System.out.println(primeCount);
    }
}