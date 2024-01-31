import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] temp = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int d = 0; d < N; d++) {
			temp[d] = Integer.parseInt(st.nextToken());
		}
		int tempSum = 0;
		int maxTempSum = Integer.MIN_VALUE;
		for (int i = 0; i < N-K+1; i++) {
			tempSum = 0;
			for(int j = i; j < i+K; j++) {
				tempSum += temp[j];
			}
			if (maxTempSum < tempSum)
				maxTempSum = tempSum;
		}
		System.out.println(maxTempSum);
	}
}