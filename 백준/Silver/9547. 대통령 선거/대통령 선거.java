import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken()); // 후보의 수
			int V = Integer.parseInt(st.nextToken()); // 유권자의 수
			int[][] votes = new int[V][C + 1];
			int[] firstVote = new int[C + 1];
			for (int i = 0; i < V; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= C; j++) {
					int candidate = Integer.parseInt(st.nextToken());
					votes[i][candidate] = j;
					if (j == 1) {
						firstVote[candidate]++;
					}
				}
			}

			int first = 0, second = 0;
			int firstCount = 0, secondCount = 0;
			for (int i = 1; i <= C; i++) {
				if (firstVote[i] > firstCount) {
					second = first;
					secondCount = firstCount;
					first = i;
					firstCount = firstVote[i];
				} else if (firstVote[i] > secondCount) {
					second = i;
					secondCount = firstVote[i];
				}
			}

			if (V % 2 == 0) {
				if (firstVote[first] >= V / 2) {
					sb.append(first).append(" ").append(1).append("\n");
					continue;
				}
			} else {
				if (firstVote[first] > V / 2) {
					sb.append(first).append(" ").append(1).append("\n");
					continue;
				}
			}

			int[] secondVote = new int[C + 1];
			for (int i = 0; i < V; i++) {
				if (votes[i][first] < votes[i][second]) {
					secondVote[first]++;
				} else {
					secondVote[second]++;
				}
			}
			if (secondVote[first] > secondVote[second]) {
				sb.append(first).append(" ").append(2).append("\n");
			} else {
				sb.append(second).append(" ").append(2).append("\n");
			}
		}
		System.out.println(sb);
	}
}
