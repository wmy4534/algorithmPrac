import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static int[] alpha = new int[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			char c = str.charAt(i);
			alpha[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (M >= alpha[i]) {
				M -= alpha[i];
				alpha[i] = 0;
			} else {
				alpha[i] -= M;
				M = 0;
				break;
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			char c = str.charAt(i);
			int idx = c - 'a';
			if (alpha[idx] > 0) {
				sb.append(c);
				alpha[idx]--;
			}
		}
		
		System.out.print(sb.reverse());
		
	}
}
