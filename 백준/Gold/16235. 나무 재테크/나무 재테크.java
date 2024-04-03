import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Deque<Integer>[][] map;
	static int[][] addNutrients;
	static int[][] currentNutrients;
	static List<int[]> deadTree;
	static int treeCnt = 0;
	static List<int[]> adultTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Deque[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				map[r][c] = new ArrayDeque<>();
			}
		}

		addNutrients = new int[N + 1][N + 1];
		currentNutrients = new int[N + 1][N + 1];
		treeCnt = M;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				currentNutrients[r][c] = 5;
			}
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				addNutrients[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			map[r][c].offerFirst(age);
		}
		for (int year = 0; year < K; year++) {
			spring();
			summer();
			autumn();
			winter();
		}
		System.out.println(treeCnt);
	}

	private static void spring() { // 양분 먹고 나이 증가 양분이 모자라면 죽음, 뒤에서부터 양분 확인
		adultTree = new ArrayList<>();
		deadTree = new ArrayList<>();
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				int size = map[r][c].size();
				for (int i = 0; i < size; i++) { // 해당 영역에 존재하는 나무 수만큼
					int tree = map[r][c].pollFirst(); // 해당 영역에서 작은 나무 순서대로
					if (currentNutrients[r][c] >= tree) {
						currentNutrients[r][c] -= tree;
						tree++;
						if (tree % 5 == 0) { // 만약 나무가 5의 배수라면 번식 가능
							adultTree.add(new int[] { r, c });
						}
						map[r][c].offerLast(tree);
					} else { // 영양소가 더 적다면 여름에 죽을 나무
						deadTree.add(new int[] { r, c, tree });
					}
				}
			}
		}
	}

	private static void summer() { // 죽은 나무가 양분으로, 나이 / 2만큼
		treeCnt -= deadTree.size();
		for (int i = 0; i < deadTree.size(); i++) {
			int[] tmp = deadTree.get(i);
			currentNutrients[tmp[0]][tmp[1]] += (tmp[2] / 2);
		}
	}

	private static void autumn() { // 가을에는 나무 번식 8방향
		for (int i = 0; i < adultTree.size(); i++) {
			int[] tmp = adultTree.get(i);
			for (int idx = 0; idx < 8; idx++) {
				int nr = tmp[0] + dr[idx];
				int nc = tmp[1] + dc[idx];
				if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
					map[nr][nc].offerFirst(1);
					treeCnt++;
				}
			}
		}
	}

	private static void winter() { // 땅에 직접 양분 추가
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				currentNutrients[r][c] += addNutrients[r][c];
			}
		}
	}
}