import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] parent = new int[n];
		int[] rank = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		int result = 0;
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int rootA = find(parent, a);
			int rootB = find(parent, b);

			if (rootA == rootB) {
				result = i;
				break;
			}

			if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
				rank[rootB]++;
			} else {
				parent[rootB] = rootA;
				rank[rootA]++;
			}
		}
		System.out.println(result);
	}

	private static int find(int[] parent, int x) {
		if (parent[x] != x) {
			parent[x] = find(parent, parent[x]);
		}
		return parent[x];
	}
}