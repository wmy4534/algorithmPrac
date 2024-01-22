import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		HashSet<Integer> rest = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			rest.add(num%42);
		}
		System.out.println(rest.size());
	}
}