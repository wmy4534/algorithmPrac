import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int[] as = new int[5];
			for(int n = 1; n <= a; n++) {
				as[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int[] bs = new int[5];
			for(int n = 1; n <= b; n++) {
				bs[Integer.parseInt(st.nextToken())]++;
			}
			boolean draw = true;
			for(int n = 4; n >= 1; n--) {
				if(as[n] > bs[n]) {
					sb.append("A").append("\n");
					draw = false;
					break;
				}
				else if(as[n] < bs[n]) {
					sb.append("B").append("\n");
					draw = false;
					break;
				}
			}
			if (draw)
				sb.append("D").append("\n");
		}
		System.out.println(sb);
	}
}