import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cn = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] coArr = new int[cn][2];

		for (int i = 0; i < cn; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			coArr[i][0] = x;
			int y = Integer.parseInt(st.nextToken());
			coArr[i][1] = y;
		}
		Arrays.sort(coArr, (o1, o2) -> (o1[1] == o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]));


		for (int i = 0; i < cn; i++) {
			sb.append(coArr[i][0] + " " + coArr[i][1] + "\n");
		}
		System.out.println(sb);
	}
}