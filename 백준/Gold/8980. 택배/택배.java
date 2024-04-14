import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 마을 수
		int C = Integer.parseInt(st.nextToken()); // 트럭 용량
		int M = Integer.parseInt(br.readLine()); // 보내는 박스 정보의 수
		List<int[]>[] map = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 보내는 마을
			int to = Integer.parseInt(st.nextToken()); // 받는 마을
			int boxNum = Integer.parseInt(st.nextToken()); // 박스 수
			map[from].add(new int[] { to, boxNum });
		}

		int delivered = 0;
		int capacity = 0;
		int[] truck = new int[N + 1]; // 배달할 위치의 짐
		for (int i = 1; i <= N; i++) { // 트럭의 현재 위치
			delivered += truck[i]; // 배달한 박스 수
			capacity -= truck[i]; // 트럭에 실린 용량에서 빼준다.
			truck[i] = 0; // 배달했으므로 0으로 만들어주고
			// 여기까지는 배달 완료
			for (int j = 0; j < map[i].size(); j++) { // 짐 싣기
				int[] box = map[i].get(j); // 어디로 보낼지, 몇 개인지 정보
				if (capacity + box[1] <= C) {
					truck[box[0]] += box[1];
					capacity += box[1];
				} else {
					int num = box[1];
					truck[box[0]] += C - capacity; // 남은 용량만큼 채운다.
					num -= (C - capacity);
					capacity = C;
					for (int k = N; k > box[0]; k--) {
						if (truck[k] > 0) {
							truck[box[0]] += Math.min(num, truck[k]);
							truck[k] -= Math.min(num, truck[k]);
							num -= Math.min(num, truck[k]);
							if (num == 0) {
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(delivered);
	}
}