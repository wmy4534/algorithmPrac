import java.util.*;
import java.io.*;

public class Main {
	static class Friend {
		Set<Integer> set = new HashSet<>();
		int num = 1;

		Friend() {
		}

		Friend(int id) {
			this.set.add(id);
		}
	}

	static Friend[] friends = new Friend[200000];
	static Map<String, Integer> ids;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			ids = new HashMap<>();
			int id = 0;
			int F = Integer.parseInt(br.readLine());
			for (int f = 0; f < F; f++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if (!ids.containsKey(name1)) {
					ids.put(name1, id);
					friends[id] = new Friend(id);
					id++;
				}
				if (!ids.containsKey(name2)) {
					ids.put(name2, id);
					friends[id] = new Friend(id);
					id++;
				}
				Friend friend1 = friends[ids.get(name1)];
				Friend friend2 = friends[ids.get(name2)];
				if (friend1 == friend2) { // 이미 친구라면
					sb.append(friend1.num);
				} else {
					if (friend1.num > friend2.num) {
						friend1.num += friend2.num;
						friend1.set.addAll(friend2.set);
						for (Integer idx : friend2.set) {
							friends[idx] = friend1;
						}
						sb.append(friend1.num);
					} else {
						friend2.num += friend1.num;
						friend2.set.addAll(friend1.set);
						for (Integer idx : friend1.set) {
							friends[idx] = friend2;
						}
						sb.append(friend2.num);
					}
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}