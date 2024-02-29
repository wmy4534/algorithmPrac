import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] arr = new long[100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			long result = find(N-1); // 배열 시작 인덱스가 0이므로
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}

	private static long find(int N) {
		if (arr[N] != 0)
			return arr[N];
		arr[N] = find(N - 2) + find(N - 3);
		return arr[N];
	}
}