import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(sb.readLine());
		int[] pT = new int[N];
		StringTokenizer st = new StringTokenizer(sb.readLine());
		for (int i = 0; i < N; i++) {
			pT[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pT);
		int totalTime = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				totalTime += pT[j];
			}
		}
		System.out.println(totalTime);

	}
}