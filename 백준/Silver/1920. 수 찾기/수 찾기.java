import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int arrNum = Integer.parseInt(br.readLine());
		int[] numArr = new int[arrNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arrNum; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numArr);
		
		int targetCase = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < targetCase; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (binarySearch(numArr, target)) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		
		System.out.print(sb);
	}
	
	private static boolean binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (arr[mid] == target) {
				return true;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return false;
	}
}