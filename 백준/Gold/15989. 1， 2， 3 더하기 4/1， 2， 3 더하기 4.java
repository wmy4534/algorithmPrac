import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int num = sc.nextInt();
			int result = 0;
			while (num >= 0) {
				result += (num/2) + 1;
				num -= 3;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}