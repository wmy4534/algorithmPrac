import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		String num = br.readLine();
		for (int i = 0; i < N; i++) {
			int plus = num.charAt(i) - '0';
			sum += plus;
		}
		System.out.println(sum);
		br.close();
	}
}
