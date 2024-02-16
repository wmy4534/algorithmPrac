import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		Loop: for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long V = Long.parseLong(st.nextToken());
			int count = 0;
			boolean left = false; // 루트로 올 때 왼쪽에서 왔는지 여부
			while (V > 1) {
				if (V == 2) { // 왼쪽에서 왔을 경우
					left = true;
				}
				V /= 2;
				count++;
			}
			if (left && V * 2 + 1 <= N) { // 만약 왼쪽에서 왔고, 루트의 오른쪽이 있다면 오른쪽으로 보냄
				V = V * 2 + 1;
				count++;
			} else if (!left && V * 2 <= N) { // 만약 오른쪽에서 왔다면, 루트의 왼쪽으로 보냄
				V *= 2;
				count++;
			} else { // 만약 왼쪽에서 왔는데 오른쪽이 없을 경우
				sb.append("#" + t + " " + count + "\n");
				continue Loop;
			}
			while (V * 2 <= N) { // 이후 N까지 계속해서 내려간다.
				V *= 2;
				count++;
			}
			sb.append("#" + t + " " + count + "\n");
		}
		System.out.println(sb);
	}
}