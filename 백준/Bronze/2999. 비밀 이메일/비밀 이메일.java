import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuilder sb = new StringBuilder();
		int maxR = 1;
		for(int i = 1; i < str.length(); i++) {
			if (i*i > str.length()) {
				maxR = i-1;
				break;
			}
		}
		int r = 1;
		int c = str.length();
		for(int i = maxR; i >= 1; i--) {
			if (str.length()%i == 0) {
				r = i;
				c = str.length()/i;
				break;
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = i; j < str.length(); j+=r) {
				sb.append(str.charAt(j));
			}
		}
		System.out.println(sb);
	}
}