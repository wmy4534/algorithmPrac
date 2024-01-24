import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= tc; t++) {
			int numCount = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] numArr = new int[numCount];
			for (int i = 0; i < numCount; i++) {
				numArr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(numArr);
			int result = -1;
			for (int i = numCount - 1; i > 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					int multi = numArr[i] * numArr[j];
					if (multi > result) {
						String num = multi + "";
						boolean check = true;
						for (int k = 0; k < num.length() - 1; k++) {
							if (num.codePointAt(k) - '0' > num.codePointAt(k + 1) - '0') {
								check = false;
								break;
							}
						}
						if (check) {
							result = multi;
							break;
						}
					}
				}
			}
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb);
	}
}