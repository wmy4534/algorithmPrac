import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String star = "*";
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			String stars = star.repeat(i);
			sb.append(stars).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
