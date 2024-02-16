import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = (arr.length == 1 ? arr[0] : -1);
			for (int i = 0; i < N - 1; i++) {
				Loop: for (int j = i + 1; j < N; j++) {
					int num = arr[i] * arr[j];
					String tmp = num + "";
					for (int c = 0; c < tmp.length()-1; c++) {
						if (tmp.charAt(c) > tmp.charAt(c + 1))
							continue Loop;
					}
					if (max < num)
						max = num;
				}
			}
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}
}