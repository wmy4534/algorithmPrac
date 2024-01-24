package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_20057_마법사상어와토네이도 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[][] map = new int[size][size];
		int[] rDirection = { 0, 1, 0, -1 };
		int[] cDirection = { -1, 0, 1, 0 };
		int sum = 0;
		for (int r = 0; r < size; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < size; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				sum += map[r][c];
			}
		}
		int directionIdx = 0;
		int maxCountSignal = 0;
		int movedCount = 0;
		int nowR = size / 2;
		int nowC = size / 2;
		int maxMove = 1;

		for (int count = 0; count < size * size - 1; count++) {
			nowR += rDirection[directionIdx];
			nowC += cDirection[directionIdx];
			int sand = map[nowR][nowC];
			map[nowR][nowC] = 0;

			for (int i = 0; i < 4; i++) {
				int targetR = nowR + rDirection[i];
				int targetC = nowC + cDirection[i];
				if (i == directionIdx) {
					if (targetR < size && targetR >= 0 && targetC < size && targetC >= 0) {
						map[targetR][targetC] += sand - ((int) (sand * 0.01) + (int) (sand * 0.01) + (int) (sand * 0.07)
								+ (int) (sand * 0.07) + (int) (sand * 0.02) + (int) (sand * 0.02) + (int) (sand * 0.1)
								+ (int) (sand * 0.1) + (int) (sand * 0.05));
					}

					for (int j = 0; j < 4; j++) {
						if (targetR + rDirection[j] == nowR && targetC + cDirection[j] == nowC) {
							continue;
						} else if (j == i) {
							if (targetR + rDirection[j] < size && targetR + rDirection[j] >= 0
									&& targetC + cDirection[j] < size && targetC + cDirection[j] >= 0) {
								map[targetR + rDirection[j]][targetC + cDirection[j]] += (int) (sand * 0.05);
							}
						}
					}
				} else if (targetR == nowR - rDirection[directionIdx] && targetC == nowC - cDirection[directionIdx]) {
					continue;
				} else {
					if (targetR < size && targetR >= 0 && targetC < size && targetC >= 0) {
						map[targetR][targetC] += (int) (sand * 0.07);
					}
					for (int j = 0; j < 4; j++) {
						if (targetR + rDirection[j] == nowR && targetC + cDirection[j] == nowC)
							continue;
						else if (rDirection[j] == rDirection[directionIdx]
								&& cDirection[j] == cDirection[directionIdx]) {
							if (targetR + rDirection[j] < size && targetR + rDirection[j] >= 0
									&& targetC + cDirection[j] < size && targetC + cDirection[j] >= 0) {
								map[targetR + rDirection[j]][targetC + cDirection[j]] += (int) (sand * 0.1);
							}
						} else if (rDirection[j] == rDirection[i] && cDirection[j] == cDirection[i]) {
							if (targetR + rDirection[j] < size && targetR + rDirection[j] >= 0
									&& targetC + cDirection[j] < size && targetC + cDirection[j] >= 0) {
								map[targetR + rDirection[j]][targetC + cDirection[j]] += (int) (sand * 0.02);
							}
						} else {
							if (targetR + rDirection[j] < size && targetR + rDirection[j] >= 0
									&& targetC + cDirection[j] < size && targetC + cDirection[j] >= 0) {
								map[targetR + rDirection[j]][targetC + cDirection[j]] += (int) (sand * 0.01);
							}
						}
					}
				}

			}
			movedCount++;
			if (maxMove == movedCount) {
				movedCount = 0;
				directionIdx++;
				directionIdx = directionIdx % 4;
				maxCountSignal++;
			}
			if (maxCountSignal == 2 && maxMove < size-1) {
				maxMove++;
				maxCountSignal = 0;
			}
		}
		int remain = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				remain += map[i][j];
			}
		}
		System.out.println(sum - remain);

	}
}
