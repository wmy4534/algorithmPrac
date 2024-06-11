import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1]; // 자기보다 왼쪽에 있는 키 큰 사람의 수
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		int[] heights = new int[N]; // 줄 선 키의 순서
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (heights[j] == 0 && cnt == arr[i]) {
					heights[j] = i;
					break;
				}
				if (heights[j] == 0)
					cnt++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(heights[i]).append(" ");
		}
		System.out.println(sb);
	}
}