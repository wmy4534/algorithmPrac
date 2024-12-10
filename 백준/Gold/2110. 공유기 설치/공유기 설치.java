import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] houses = new int[N];
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);
		final int MAX_DIST = (houses[N - 1] - houses[0]) / (C - 1);
		int answer = 0;
		
		int left = 1;
		int right = MAX_DIST;
		while (left <= right) {
			int mid = (left + right) / 2;
			int start = houses[0];
			int count = 0;
			for (int i = 1; i < N; i++) {
				if (houses[i] - start >= mid) {
					start = houses[i];
					count++;
				}
			}
			if (count >= (C - 1)) {
				left = mid + 1;
				answer = mid;
			} else {
				right = mid - 1;
			}
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
	}
}