import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= tc; t++) {
			String str = br.readLine();
			int score = 0;
			int totalScore = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'O') {
					score++;
					totalScore += score;
				} else {
					score = 0;
				}
			}
			sb.append(totalScore + "\n");
		}
		System.out.println(sb);
	}
}