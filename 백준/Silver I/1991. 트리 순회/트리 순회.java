import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char data;
	Node left;
	Node right;

	Node() {
	}

	Node(char data) {
		this.data = data;
	}
}

public class Main {
	static Node[] nodes;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nodes = new Node[N + 1];
		for (int i = 1; i < N + 1; i++) {
			nodes[i] = new Node();
		}

		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char dataIdx = st.nextToken().charAt(0);
			nodes[dataIdx - 'A' + 1].data = dataIdx;
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			if (left != '.') {
				nodes[dataIdx - 'A' + 1].left = nodes[left - 'A' + 1];
			}
			if (right != '.') {
				nodes[dataIdx - 'A' + 1].right = nodes[right - 'A' + 1];
			}
		}
		preorder(nodes[1]);
		sb.append("\n");
		inorder(nodes[1]);
		sb.append("\n");
		postorder(nodes[1]);
		System.out.println(sb);

	}

	private static void preorder(Node node) {
		if (node == null)
			return;
		sb.append(node.data);
		preorder(node.left);
		preorder(node.right);
	}

	private static void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		sb.append(node.data);
		inorder(node.right);
	}

	private static void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		sb.append(node.data);
	}
}