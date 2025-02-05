import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		final int x = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		for (int i = l; i <= r; i++) {
			set.add(i | x);
		}
		int num = 0;
		while (set.contains(num)) {
			num++;
		}
		System.out.println(num);
		br.close();
	}
}
