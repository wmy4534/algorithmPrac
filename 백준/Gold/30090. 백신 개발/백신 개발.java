import java.util.*;
import java.io.*;

public class Main {

	static String[] strArr;
	static int N;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		strArr = new String[N];
		for (int i = 0; i < N; i++) {
			strArr[i] = br.readLine();
		}

		for (int i = 0; i < N; i++) {
			int visit = 1 << i;
			String str = strArr[i];
			backTracking(visit, str);
		}
		System.out.println(answer);
	}

	private static void backTracking(int visit, String str) {
		if (str.length() >= answer)
			return;
		if ((visit == (1 << N) - 1)) {
			answer = Math.min(answer, str.length());
			return;
		}
		int visited = visit;
		int length = str.length();
		for (int i = 0; i < length; i++) {
			String newStr = str.substring(0, length-i);
			for (int j = 0; j < N; j++) {
				if (newStr.length() > strArr[j].length())
					continue;
				if ((visited & 1 << j) == 0 && strArr[j].endsWith(newStr)) {
					visited |= (1 << j);
					String tmp = strArr[j] + str.substring(length - i);
					backTracking(visit | (1 << j), tmp);
				}
			}
		}
		visited = visit;
		for (int i = 0; i < length; i++) {
			String newStr = str.substring(i, length);
			for (int j = 0; j < N; j++) {
				if (newStr.length() > strArr[j].length())
					continue;
				if((visited & 1 << j) == 0 && strArr[j].startsWith(newStr)) {
					visited |= (1 << j);
					String tmp = str.substring(0, i) + strArr[j];
					backTracking(visit | (1 << j), tmp);
					
				}
			}
		}
	}
}