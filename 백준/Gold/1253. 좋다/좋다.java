import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N-1;
			while (left < right) {
				if (left == i) {
					left++;
					if (left >= right)
						break;
				} else if (right == i) {
					right--;
					if (left >= right)
						break;
				}
				int sum = arr[left] + arr[right];
				if (sum > arr[i]) right--;
				else if (sum < arr[i]) left++;
				else {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}