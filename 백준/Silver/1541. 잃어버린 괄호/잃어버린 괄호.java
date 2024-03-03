import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] tmp = str.split("-");
		int result = 0;
		String[] s = tmp[0].split("\\+");
		for (int i = 0; i < s.length; i++) {
			result += Integer.parseInt(s[i]);
		}
		for (int i = 1; i < tmp.length; i++) {
			s = tmp[i].split("\\+");
			for (int j = 0; j < s.length; j++) {
				result -= Integer.parseInt(s[j]);
			}
		}
		System.out.println(result);
	}
}