import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		String str = "" + A + B;
		int D = Integer.parseInt(str) - C;
		sb.append(A + B - C).append("\n").append(D);
		System.out.println(sb);
		br.close();
	}
}
