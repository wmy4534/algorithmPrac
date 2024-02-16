import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append("\n");
			int N = Integer.parseInt(br.readLine());
			String[] names = new String[N];
			for (int i = 0; i < N; i++) {
				names[i] = br.readLine();
			}

			Arrays.sort(names, (o1, o2) -> (o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length()));
			for (int i = 0; i < N-1; i++) {
				if (!(names[i].equals(names[i + 1]))) {
					sb.append(names[i]).append("\n");
				}
			}
			sb.append(names[N-1]).append("\n");
		}
		System.out.println(sb);
	}
}