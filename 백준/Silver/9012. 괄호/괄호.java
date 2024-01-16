import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        String result = null;

        for (int i=0; i<caseNum; i++) {
            String ps = sc.next();
            int countOpen = 0;
            int countClose = 0;
            for (int j=0; j<ps.length(); j++) {
                char str = ps.charAt(j);
                if (str == '(') {
                    countOpen++;
                } else if (str == ')') {
                    countClose++;
                }
                if (countOpen < countClose) {
                    result = "NO";
                    break;
                }
            }
            if (countOpen != countClose) {
                result = "NO";
            } else {
                result = "YES";
            }

            System.out.println(result);
        }


    }
}