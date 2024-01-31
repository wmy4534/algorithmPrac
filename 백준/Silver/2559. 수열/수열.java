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
		int[] prefixSum = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int d = 0; d < N; d++) {
			temp[d] = Integer.parseInt(st.nextToken());
		}
		prefixSum[0] = temp[0];
		for (int i = 1; i < N; i++) {
			prefixSum[i] = prefixSum[i-1]+temp[i];
		}
		
		int max = prefixSum[K-1];
		
		for (int i = K; i < N; i++) {
			int tmp = prefixSum[i]-prefixSum[i-K];
			if (max < tmp)
				max = tmp;
		}
		if(K == N)
			max = prefixSum[K-1];
		System.out.println(max);
	}
}