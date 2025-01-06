import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int idx = c - 'a';
			if (arr[idx] < 0) {
				arr[idx] = i;
			}
		}

		for (int i = 0; i < 26; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
		br.close();
	}
}
