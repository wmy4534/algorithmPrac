import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[][] countArr = new long[41][2];
		countArr[0][0] = 1L;
		countArr[1][1] = 1L;
		for (int i = 2; i <= 40; i++) {
			countArr[i][0] = countArr[i-1][0] + countArr[i-2][0];
			countArr[i][1] = countArr[i-1][1] + countArr[i - 2][1];
		}
		
		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(countArr[num][0]).append(" ").append(countArr[num][1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
