import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {

	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));
		}
		list.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			Point point = list.get(i);
			sb.append(point.x + " " + point.y).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
