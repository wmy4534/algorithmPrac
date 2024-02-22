import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] positiveCards = new int[10000001];
		int[] negativeCards = new int[10000001];
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num >= 0) {
				positiveCards[num]++;
			} else {
				negativeCards[Math.abs(num)]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num >= 0) {
				sb.append(positiveCards[num]).append(" ");
			} else {
				sb.append(negativeCards[Math.abs(num)]).append(" ");
			}
		}
		System.out.println(sb);
	} 
}