import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			int b = 1;
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] == b) {
					b++;
				}
				b++;
			}
			b--;
			bw.write(b+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
