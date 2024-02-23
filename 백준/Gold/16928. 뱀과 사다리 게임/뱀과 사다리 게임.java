import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] map = new int[101]; // 전체 게임 지도
	static int[] ladderOrSnake = new int[101]; // 사다리 뱀 지도

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ladderNum = Integer.parseInt(st.nextToken());
		int snakeNum = Integer.parseInt(st.nextToken());
		for (int i = 0; i < ladderNum + snakeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			ladderOrSnake[start] = end;
		}

		for (int i = 1; i < 101; i++) { // 전체 지도에서 위치
			if (ladderOrSnake[i] > 0)
				continue;
			for (int j = 1; j < 7; j++) { // 주사위로 더할 수 있는 수
				int current = i + j; // 움직일 수 있는 위치
				if (current > 100) // 100을 벗어난다면 멈춘다.
					break;
				if (map[current] > 0) { // 만약 움직일 수 있는 위치에 값이 있다면
					map[current] = Math.min(map[i] + 1, map[current]); // 비교한다.
				} else { // 움직일 수 있는 위치에 값이 없다면
					map[current] = map[i] + 1; // 값을 넣는다.
				}
				if (ladderOrSnake[current] > 0) { // 사다리나 뱀이 있을 경우
					if (map[ladderOrSnake[current]] > 0) { // 사다리나 뱀의 도착지에 값이 있고,
						if (map[current] < map[ladderOrSnake[current]]) { // 사다리나 뱀을 타고 가는 게 더 빠르다면
							map[ladderOrSnake[current]] = map[current]; // 사다리나 뱀의 도착지를 수정한다.
							if (current > ladderOrSnake[current]) { // 뱀이라면
								i = ladderOrSnake[current] - 1; // 위치를 다시 뒤로 돌린다.
							}
						}
					} else { // 사다리나 뱀의 도착지가 값이 없다면 => 무조건 사다리다.
						map[ladderOrSnake[current]] = map[current];
					}
				}
			}
		}
		System.out.println(map[100]);

	}
}