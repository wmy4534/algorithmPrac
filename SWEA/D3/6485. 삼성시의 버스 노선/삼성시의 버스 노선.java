import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			sb.append("#" + t + " ");
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N + 1];
			int[] B = new int[N + 1];
			for (int n = 1; n <= N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				A[n] = Integer.parseInt(st.nextToken());
				B[n] = Integer.parseInt(st.nextToken());
			}

			int P = Integer.parseInt(br.readLine());
			for (int c = 1; c <= P; c++) {
				int C = Integer.parseInt(br.readLine());
				int count = 0;
				for (int n = 1; n <= N; n++) {
					if (C >= A[n] && C <= B[n]) {
						count++;
					}
				}
				sb.append(count + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
