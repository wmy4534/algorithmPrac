import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        count += num / 125;
        count += num / 25;
        count += num / 5;
        System.out.println(count);
    }
}