import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[8];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 8; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		String[] arr = new String[3];
		arr[0] = "ascending";
		arr[1] = "descending";
		arr[2] = "mixed";
		String status = nums[1] > nums[0] ? arr[0] : arr[1];
		for (int i = 2; i < 8; i++) {
			if (nums[i] > nums[i - 1] && status.equals(arr[0])) {
				continue;
			} else if (nums[i] < nums[i - 1] && status.equals(arr[1])) {
				continue;
			} else {
				status = arr[2];
				break;
			}
		}
		System.out.println(status);
	}
}
