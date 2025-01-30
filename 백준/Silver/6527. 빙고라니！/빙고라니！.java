import java.util.*;
import java.io.*;

public class Main {

	static final String GAME_END = "BULLSHIT";
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int gameCnt = 0;
		int wordCnt = 0;
		while (true) {
			String str = br.readLine();
			if (str == null || str.length() == 0) {
				break;
			}
			str = str.toUpperCase() + " ";
			int start = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) < 65 || str.charAt(i) > 90) {
					String tmp = str.substring(start, i);
					if (tmp.length() == 0) {
						start = i + 1;
						continue;
					}
					if (tmp.equals(GAME_END)) {
						gameCnt++;
						wordCnt += set.size();
						set = new HashSet<>();
						start = i + 1;
					} else {
						set.add(tmp);
						start = i + 1;
					}
				}
			}
		}
		int gcd = GCD(wordCnt, gameCnt);
		System.out.println(wordCnt / gcd + " / " + gameCnt / gcd);
		br.close();
	}

	private static int GCD(int wordCnt, int gameCnt) {
		if (gameCnt == 0)
			return wordCnt;
		return GCD(gameCnt, wordCnt % gameCnt);
	}
}
