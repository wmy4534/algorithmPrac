import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		String str;
		TreeMap<String, Node> next = new TreeMap<>();
	}

	static StringTokenizer st;
	static TreeMap<String, Node> nodes = new TreeMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int id = 0;
		for (int n = 0; n < N; n++) {
			TreeMap<String, Node> map = nodes;
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int i = 0; i < num; i++) {
				String str = st.nextToken();
				if (map.containsKey(str)) {
					map = map.get(str).next;
				} else {
					Node node = new Node();
					node.str = str;
					map.put(str, node);
					map = map.get(str).next;
				}
			}
		}
		dfs(nodes, 0);
		System.out.print(sb);
	}

	private static void dfs(TreeMap<String, Node> map, int depth) {
		if (map.isEmpty()) {
			return;
		}
		Set<String> set = map.keySet();
		for (String str : set) {
			for (int i = 0; i < depth; i++) {
				sb.append("--");
			}
			sb.append(str);
			sb.append("\n");
			dfs(map.get(str).next, depth + 1);
		}

	}
}