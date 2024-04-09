import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class shark {
		int speed; // s
		int direction; // d
		int size; // z

		shark() {
		}

		shark(int s, int d, int z) {
			this.speed = s;
			this.direction = d; // 1은 위, 2는 아래, 3은 오른쪽, 4는 왼쪽 상하우좌
			this.size = z;
		}
	}

	static int R, C, M;
	static shark[][] map;
	static int getSize = 0;
	static shark[][] tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 상어의 수

		map = new shark[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new shark(s, d, z);
		}

		for (int i = 1; i <= C; i++) { // 낚시꾼이 한 칸씩 이동함
			fishing(i);
			moving();
			for (int r = 1; r <= R; r++) {
				for (int c = 1; c <= C; c++) {
					map[r][c] = tmp[r][c];
				}
			}
		}
		System.out.println(getSize);
	}

	private static void moving() {
		tmp = new shark[R + 1][C + 1]; // 상어 위치를 옮겨담을 지도
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (map[r][c] != null) { // 상어의 방향은 1, 2는 위 아래, 3, 4는 오른쪽 왼쪽이므로 서로 숫자 변경
					int speed = map[r][c].speed;
					int direction = map[r][c].direction;
					int size = map[r][c].size;
					int nr = r;
					int nc = c;
					int distance = 0;
					map[r][c] = null;
					if (direction <= 2) {
						distance = speed % ((R - 1) * 2); // 움직일 거리
					} else {
						distance = speed % ((C - 1) * 2);
					}
					while (distance > 0) {
						if (direction == 1 && nr == 1)
							direction = 2;
						else if (direction == 2 && nr == R)
							direction = 1;
						if (direction == 4 && nc == 1)
							direction = 3;
						else if (direction == 3 && nc == C)
							direction = 4;
						switch (direction) {
						case 1:
							nr--;
							break;
						case 2:
							nr++;
							break;
						case 3:
							nc++;
							break;
						case 4:
							nc--;
							break;
						}
						distance--;
					}
					if (tmp[nr][nc] != null) {
						if (size > tmp[nr][nc].size) {
							tmp[nr][nc] = new shark(speed, direction, size);
						}
					} else {
						tmp[nr][nc] = new shark(speed, direction, size);
					}
				}
			}
		}

	}

	private static void fishing(int location) {
		for (int r = 1; r <= R; r++) {
			if (map[r][location] != null) {
				getSize += map[r][location].size;
				map[r][location] = null;
				return;
			}
		}
	}

}