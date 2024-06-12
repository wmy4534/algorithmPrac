import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수열의 길이
		int K = Integer.parseInt(st.nextToken()); // 같은 원소의 허용 개수
		int[] arr = new int[N];
		int[] count = new int[100001];
		int maxCnt = 0; // 최장 수열 길이
		st = new StringTokenizer(br.readLine());
		int startIdx = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			count[arr[i]]++;
			if (count[arr[i]] <= K)
				continue;
			else {
				if (maxCnt < i-startIdx)
					maxCnt = i-startIdx;
				for (int j = startIdx; j < i; j++) {
					if (arr[j] == arr[i]) {
						startIdx = j+1;
						count[arr[i]]--;
						break;
					} else {
						count[arr[j]]--;
					}
				}
			}
		}
		maxCnt = Math.max(maxCnt, N-startIdx);
		System.out.println(maxCnt);
	}
}