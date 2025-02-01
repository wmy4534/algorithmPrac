import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] homeworks = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			homeworks[i][0] = d;
			homeworks[i][1] = t;
		}
		Arrays.sort(homeworks, (o1, o2) -> o2[1] - o1[1]);
		
		int last = homeworks[0][1];
		for (int i = 0; i < n; i++) {
			last = Math.min(homeworks[i][1], last);
			last -= homeworks[i][0];
		}
		System.out.println(last);
		
	}
}
