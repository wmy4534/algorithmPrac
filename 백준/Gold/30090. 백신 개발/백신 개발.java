import java.util.*;
import java.io.*;

public class Main {

	static String[] strArr;
	static int answer = Integer.MAX_VALUE;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		strArr = new String[N];
		for (int i = 0; i < N; i++) {
			strArr[i] = br.readLine();
		}
		
		for (int i = 0; i < N; i++) {
			int visit = 1 << i;
			find(visit, strArr[i]);
		}
		
		System.out.println(answer);
	}

	private static void find(int visit, String string) {
		if (string.length() >= answer)
			return;
		if (visit == (1 << N) - 1) {
			answer = string.length();
			return;
		}
		int currentVisit = visit;
		for (int i = 0; i < N; i++) {
			if ((currentVisit & 1 << i) == 0) {
				currentVisit = currentVisit | (1 << i);
				int length1 = string.length();
				int length2 = strArr[i].length();
				for (int k = Math.min(length1, length2); k > 0; k--) {
					if (string.substring(0, k).equals(strArr[i].substring(length2 - k, length2))) {
						String newStr = strArr[i].substring(0, length2 - k) + string;
						find(visit | 1 << i, newStr);
					}
					if (string.substring(length1 - k, length1).equals(strArr[i].substring(0, k))) {
						String newStr = string.substring(0, length1 - k) + strArr[i];
						find(visit | 1 << i, newStr);
					}
				}
			}
		}
		
	}
	
	
}