import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/*
	빈 칸: 언제나 이동할 수 있다. ('.')
	벽: 절대 이동할 수 없다. ('#')
	열쇠: 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. ('a', 'b', 'c', 'd', 'e', 'f')
	문: 대응하는 열쇠가 있을 때만 이동할 수 있다. ('A', 'B', 'C', 'D', 'E', 'F')
	민식이의 현재 위치: 빈 곳이고, 민식이가 현재 서 있는 곳이다. ('0')
	출구: 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. ('1')
 */

public class Main {
	static class Minsik {
//		public int cnt = -1;

		public boolean[] keys = new boolean[6]; // 가지고 있는 키 ('a', 'b', 'c', 'd', 'e', 'f')

		public Minsik() {
		}

//		public Minsik(int cnt) {
//			this.cnt = cnt;
//		}

		public void getKey(char key) { // 키를 획득함
			this.keys[key - 'a'] = true;
		}

		public boolean isSame(Minsik minsik) { // 같은 민식이인지 확인
			for (int i = 0; i < 6; i++) {
				if (this.keys[i] != minsik.keys[i]) // 만약 가지고 있는 키가 다르다면 다른 민식
					return false;
			}
			return true; // 모든 키가 같다면 같은 민식
		}
	}

	static int N;
	static int M;
	static char[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<Minsik>[][] escapeMap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		escapeMap = new ArrayList[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				escapeMap[r][c] = new ArrayList<>();
			}
		}

		int curR = 0;
		int curC = 0;
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
				if (map[r][c] == '0') {
					escapeMap[r][c].add(new Minsik());
					curR = r;
					curC = c;
				}
			}
		}
//		System.out.println(escapeMap[curR][curC].get(0).cnt);
//		Minsik tmp = new Minsik();
//		tmp.keys = escapeMap[curR][curC].get(0).keys;
//		System.out.println(Arrays.toString(escapeMap[curR][curC].get(0).keys));
//		System.out.println(Arrays.toString(tmp.keys));
//		tmp.getKey('a');
//		System.out.println(Arrays.toString(escapeMap[curR][curC].get(0).keys));
//		System.out.println(Arrays.toString(tmp.keys));

		int result = -1;
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { curR, curC });
		Bfs: while (!dq.isEmpty()) {
			int size = dq.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				int[] cur = dq.pollFirst();
				curR = cur[0];
				curC = cur[1];
				if (map[curR][curC] == '1') {
//					System.out.println("도착" + curR + ", " + curC); // 도착 알림
					result = cnt - 1;
					break Bfs;
				}
				for (int m = 0; m < escapeMap[curR][curC].size(); m++) {
					path: for (int idx = 0; idx < 4; idx++) {
						Minsik minsik = new Minsik();
						minsik.keys = escapeMap[curR][curC].get(m).keys.clone(); // 지도에서 위치한 민식이
//						System.out.println("민식이 생성");
						int nr = curR + dr[idx];
						int nc = curC + dc[idx];
						if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != '#') {
//							System.out.println("새로운 좌표 : " + nr + ", " + nc);
							if (map[nr][nc] - 'a' >= 0 && map[nr][nc] - 'a' < 6) {
								minsik.getKey(map[nr][nc]);
							} else if (map[nr][nc] - 'A' >= 0 && map[nr][nc] - 'A' < 6) {
								if (!minsik.keys[map[nr][nc] - 'A']) {
//									System.out.println("열쇠를 가지고 있지 않아! 돌아가!!!!");
									continue path; // 열쇠를 가지고 있지 않으면 패스
								}
							}
							for (int j = 0; j < escapeMap[nr][nc].size(); j++) { // 움직이는 곳에 같은 민식이가 있는지 확인
								if (escapeMap[nr][nc].get(j).isSame(minsik)) { // 만약에 같은 민식이가 있다면 패스
//									System.out.println("이미 중복된 민식이가 있어");
									continue path;
								}
							}
//							System.out.println("중복된 민식이가 없어");
							escapeMap[nr][nc].add(minsik);
//							System.out.println("민식이 더하기" + nr + ", " + nc);
							dq.add(new int[] { nr, nc });
						}
					}
				}
			}

		}

		System.out.println(result);
	}
}