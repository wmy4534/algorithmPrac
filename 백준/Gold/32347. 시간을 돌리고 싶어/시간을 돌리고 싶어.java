import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 현재 일
		int K = Integer.parseInt(st.nextToken()); // 타임머신 최대 사용 횟수
		st = new StringTokenizer(br.readLine());
		boolean[] arr = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = st.nextToken().equals("1");
		}
		int[] posDay = new int[N + 1]; // 타임머신 사용 가능한 가장 가까운 미래
		int useDay = N;
		for (int i = N; i > 1; i--) {
			if (arr[i]) {
				useDay = i;
			}
			posDay[i] = useDay;
		}
		int min = 1;
		int max = N;
		int T = Integer.MAX_VALUE;
		while (min <= max) {
			int current = N;
			int count = 0;
			int mid = (min + max) / 2;
			while (current > 1) {
				int init = current;
				count++;
				current -= mid;
				if (current <= 1) {
					break;
				}
				current = posDay[current];
				if (init == current) {
					count = Integer.MAX_VALUE;
					break;
				}
			}
			if (count > K) { // K번 사용했으면 더 줄여볼만 하다.
				min = mid + 1;
			} else {
				T = Math.min(T, mid);
				max = mid - 1;
			}
		}
		System.out.println(T);
		br.close();
	}
}
