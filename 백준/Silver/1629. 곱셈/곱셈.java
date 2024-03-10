import java.util.Scanner;

public class Main {
	static long c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		c = sc.nextLong();
		long result = findRest(a%c, b);
		System.out.println(result);
	}
	
	private static long findRest(long a, long b) {
		if (b == 1) {
			return a;
		}
		if (b % 2 == 0) {
			long num = findRest(a, b/2);
			return (num*num) % c;
		} else {
			long num = findRest(a, b/2);
			return ((num*num)%c*(a%c))%c;
		}
	}
}