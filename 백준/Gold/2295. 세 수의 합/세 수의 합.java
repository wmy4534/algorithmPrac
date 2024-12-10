import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Set<Integer> set = new HashSet<Integer>();
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			arr[n] = num;
			set.add(num);
		}
		Arrays.sort(arr);
		for (int k = N - 1; k >= 0; k--) {
			int result = arr[k];
			for (int x = k; x >= 0; x--) {
				int a = arr[x];
				for (int y = x; y >= 0; y--) {
					int b = arr[y];
					int num = result - a - b;
					if (num < 0) {
						continue;
					} else if (num > a) {
						break;
					} else {
						int idx = Arrays.binarySearch(arr, num);
						if (idx < 0) {
							continue;
						} else {
							System.out.println(result);
							return;
						}
					}
				}
			}
		}
	}
}