import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String pattern = br.readLine();
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
		int len = p.length;
		int count = 0;
		Loop: for (int i = 0; i <= str.length() - len; i++) {
			for (int j = 0; j < len; j++) {
				if (s[i + j] != p[j]) {
					continue Loop;
				}
			}
			count++;
			i += len-1;
		}
		System.out.println(count);
	}
}