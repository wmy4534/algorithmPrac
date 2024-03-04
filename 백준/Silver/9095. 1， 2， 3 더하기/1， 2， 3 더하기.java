import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] n = new int[12];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n[0] = 0; n[1] = 1; n[2] = 2; n[3] = 4;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int num = Integer.parseInt(br.readLine());
			int way = findWay(num);
			sb.append(way).append("\n");
		}
		System.out.print(sb);
	}
	
	private static int findWay(int num) {
		if (n[num] > 0)
			return n[num];
		n[num] = findWay(num-1) + findWay(num-2) + findWay(num-3);
		return n[num];
	}
}