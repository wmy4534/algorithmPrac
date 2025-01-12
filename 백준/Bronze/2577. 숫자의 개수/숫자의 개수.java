import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		String num = Integer.toString(A * B * C);
		int[] cntArr = new int[10];
		for (int i = 0; i < num.length(); i++) {
			int n = num.charAt(i) - '0';
			cntArr[n]++;
		}
		for (int i = 0; i < 10; i++) {
			sb.append(cntArr[i]).append("\n");
		}

		System.out.println(sb);
	}
}
