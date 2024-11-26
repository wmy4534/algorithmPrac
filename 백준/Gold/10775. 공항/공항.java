import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine()); // 게이트 수
		int P = Integer.parseInt(br.readLine()); // 비행기 수
		
		List<Integer>[] gates = new ArrayList[G + 1];
		for (int i = 1; i <= G; i++) {
			gates[i] = new ArrayList<Integer>();
		}
		
		for (int p = 1; p <= P; p++) {
			int g = Integer.parseInt(br.readLine());
			gates[g].add(p);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int maxNum = P;
		for (int i = 1; i <= G; i++) {
			List<Integer> list = gates[i];
			for (int idx = 0; idx < list.size(); idx++) {
				int num = list.get(idx);
				if (num > maxNum) {
					break;
				}
				pq.offer(num);
			}
			while (pq.size() > i) {
				int num = pq.poll();
				maxNum = num - 1;
			}
		}
		
		System.out.println(maxNum);
	}
}