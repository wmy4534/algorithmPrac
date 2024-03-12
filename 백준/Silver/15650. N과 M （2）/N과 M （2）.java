import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int[] nums;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N];
		nums = new int[M];
		for (int i = 1; i <= N; i++) {
			arr[i-1] = i;
		}
		find(0);
		System.out.print(sb);
	}
	
	private static void find(int num) {
		if (count >= nums.length) {
			for (int i = 0; i < nums.length; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = num; i < arr.length; i++) {
			nums[count++] = arr[i];
			find(i+1);
			count--;
		}
	}
}