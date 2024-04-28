import java.util.Scanner;

public class Main {
	static int N;
	static int k;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 배열의 크기
		k = sc.nextInt(); // 찾아야할 순서
		long result = binarySearch();
		System.out.println(result);
		
	}
	
	private static long binarySearch() {
		long lPoint = 1;
		long rPoint = (long)N*(long)N;
		while (lPoint < rPoint) {
			long mid = (lPoint + rPoint) / 2;
			long cnt = findCnt(mid);
			if (cnt < k)
				lPoint = mid+1;
			else
				rPoint = mid;
		}
		return Math.min(lPoint, rPoint);
	}

	private static long findCnt(long mid) {
		long cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += Math.min(mid/i, N);
			if (mid / i == 0)
				break;
		}
		return cnt;
	}
}