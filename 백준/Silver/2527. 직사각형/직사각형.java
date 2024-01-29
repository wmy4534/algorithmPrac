import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if(x2 > p1 || p2 < x1 || q2 < y1 || y2 > q1) {
				System.out.println("d");
			} else if ((x2 == p1 && y2 == q1)||(p2 == x1 && q2 == y1)||(x2 == p1 && q2 == y1) || (p2 == x1 && y2 == q1)) {
				System.out.println("c");
			} else if ((q2 == y1) || (y2 == q1) || (x2 == p1) || (p2 == x1)) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}
		}
	}
}