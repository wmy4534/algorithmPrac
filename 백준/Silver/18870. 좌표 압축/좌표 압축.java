import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int xNum = Integer.parseInt(br.readLine());
		
		int[] xs = new int[xNum];
		Set<Integer> set = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < xNum; i++) {
			xs[i] = Integer.parseInt(st.nextToken());
			set.add(xs[i]);
		}
		Map <Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for (int x : set) {
			map.put(x, idx++);
		}
		for (int x : xs) {
			sb.append(map.get(x) + " ");
		}
		System.out.println(sb);
	}
}