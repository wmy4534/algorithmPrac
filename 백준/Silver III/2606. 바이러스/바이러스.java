import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Node {
	int data;
	List<Node> next = new ArrayList<>();
	
	Node() {}
	
	Node(int data) {
		this.data = data;
	}
}

public class Main {
	
	static Node[] nodes;
	static Set<Integer> infected = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computerNum = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int connectionNum = Integer.parseInt(br.readLine()); // 연결 수
		nodes = new Node[computerNum+1];
		for (int i = 1; i <= computerNum; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 1; i <= connectionNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dataIdx = Integer.parseInt(st.nextToken());
			int nextIdx = Integer.parseInt(st.nextToken());
			nodes[dataIdx].next.add(nodes[nextIdx]);
			nodes[nextIdx].next.add(nodes[dataIdx]);
		}
		preorder(nodes[1]);
		System.out.println(infected.size()-1);
	}
	
	private static void preorder(Node node) {
		if (node == null)
			return;
		if (infected.contains(node.data))
			return;
		
		infected.add(node.data);
		for (int i = 0; i < node.next.size(); i++) {
			preorder(node.next.get(i));
		}
	}
}