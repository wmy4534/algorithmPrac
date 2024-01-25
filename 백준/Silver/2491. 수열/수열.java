import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int upCount = 1;
		int downCount = 1;
		int maxCount = 1;
		int base = Integer.parseInt(st.nextToken());
		for (int i = 1; i < tc; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > base) {
				base = num;
				upCount++;
				if (maxCount < Math.max(upCount, downCount))
					maxCount = Math.max(upCount, downCount);
				downCount = 1;
			} else if (num < base) {
				base = num;
				downCount++;
				if (maxCount < Math.max(upCount, downCount))
					maxCount = Math.max(upCount, downCount);
				upCount = 1;
			} else {
				base = num;
				downCount++;
				upCount++;
			}
			if (maxCount < Math.max(upCount, downCount))
				maxCount = Math.max(upCount, downCount);
		}
		System.out.println(maxCount);
	}
}
