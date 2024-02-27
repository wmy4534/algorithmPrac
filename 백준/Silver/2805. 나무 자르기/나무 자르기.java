import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numOfTrees = Integer.parseInt(st.nextToken());
		long target = Long.parseLong(st.nextToken());
		long[] trees = new long[numOfTrees];
		long maxHeight = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < trees.length; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			if (trees[i] > maxHeight) {
				maxHeight = trees[i];
			}
		}
		long sum = 0L;
		long start = 0L;
		long end = maxHeight;
		long height = (start + end)/2;
		while (start <= end) {
			sum = 0;
			height = (start + end)/2;
			for (int i = 0; i < trees.length; i++) { // 전체 나무의 수를 다 돌고
				sum += Math.max(trees[i]-height, 0);
			}
			if (sum > target) {
				start = height+1;
			} else if (sum < target) {
				end = height-1;
			} else {
				break;
			}
		}
		if (sum > target) {
			height++;
			long tmp = 0;
			for (int i = 0; i < trees.length; i++) {
				tmp += Math.max(trees[i]-height, 0);
			}
			if (tmp < target) {
				height--;
			}
		} else if (sum < target) {
			height--;
		}
		
		System.out.println(height);
	}
}