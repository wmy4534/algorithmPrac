import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int rpoint = N - 1;
		int min = Integer.MAX_VALUE;
		Point set = new Point();
		for (int lp = 0; lp < rpoint; lp++) {
			for (int rp = rpoint; lp < rp; rp--) {
				int sum = arr[lp] + arr[rp];
				if (sum > 0) { // 작을 수록 좋다
					if (Math.abs(sum) < min) {
						min = Math.abs(sum);
						set.x = lp;
						set.y = rp;
					}
					rpoint = rp;
				} else if (sum < 0) { // 클 수록 좋다
					rpoint = Math.min(rp + 1, rpoint); // 0보다 큰 값에서 시작할 수 있도록
					if (Math.abs(sum) < min) {
						min = Math.abs(sum);
						set.x = lp;
						set.y = rp;
					}
					break;
				} else { // 0이 나왔을 때
					System.out.println(arr[lp] + " " + arr[rp]);
					return;
				}
			}
		}
		System.out.println(arr[set.x] + " " + arr[set.y]);
	}
}