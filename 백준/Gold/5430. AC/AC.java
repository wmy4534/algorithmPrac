import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int start;
	static int end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String function = br.readLine(); // 함수를 받음
			int n = Integer.parseInt(br.readLine()); // 배열의 수
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			String result = func(function);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static String func(String function) {
		int Rcount = 0;
		start = 0;
		end = arr.length;
		for (int i = 0; i < function.length(); i++) {
			if (function.charAt(i) == 'R') {
				Rcount++;
			} else if (function.charAt(i) == 'D') {
				if (!pop(Rcount))
					return "error";
			}
		}
		arr = Arrays.copyOfRange(arr, start, end);
		if (Rcount % 2 == 1)
			reverse();
		return Arrays.toString(arr).replace(" ", "");
	}

	private static void reverse() {
		int tmp;
		for (int i = 0; i < arr.length / 2; i++) {
			tmp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = tmp;
		}
	}

	private static boolean pop(int Rcount) {
		if (Rcount % 2 == 0) {
			start++;
		} else {
			end--;
		}
		if (start > end)
			return false;
		return true;
	}
}