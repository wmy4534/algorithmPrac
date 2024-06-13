import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 게임의 수
		for (int tc = 1; tc <= T; tc++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			int[] countArr = new int[26];
			int minLen = Integer.MAX_VALUE;
			int maxLen = Integer.MIN_VALUE;
			for (int i = 0; i < W.length(); i++) {
				int idx = W.codePointAt(i)-'a';
				countArr[idx]++;
				if (countArr[idx] >= K) {
					int num = -1;
					int sIdx = 0;
					for (; sIdx <= i; sIdx++) {
						if (W.charAt(sIdx) == W.charAt(i))
							num++;
						if (countArr[idx] - num == K)
							break;
					}
					minLen = Math.min(minLen, i-sIdx+1);
					maxLen = Math.max(maxLen, i-sIdx+1);
				}
			}
			if (minLen == Integer.MAX_VALUE || maxLen == Integer.MIN_VALUE)
				sb.append(-1).append("\n");
			else
				sb.append(minLen).append(" ").append(maxLen).append("\n");
		}
		System.out.print(sb);
	}
}