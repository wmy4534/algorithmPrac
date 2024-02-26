import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] conversations = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			conversations[i][0] = start;
			conversations[i][1] = end;
		}
		Arrays.sort(conversations, (o1, o2) -> (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));
		int count = 0;
		for (int i = 0; i < conversations.length; i++) {
			int end = conversations[i][1];
			count++;
			for (int j = i + 1; j < conversations.length; j++) {
				if (conversations[j][0] >= end) {
					i = j - 1;
					break;
				}
				i = j;
			}
		}
		System.out.println(count);
	}
}