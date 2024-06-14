import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 수
		int k = Integer.parseInt(st.nextToken()); // 연속 먹는 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int[] belt = new int[N];
		int[] sushi = new int[d + 1];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		int sp = 0;
		int sum = 0;
		for (int i = 0; i < k; i++) {
			int s = belt[i];
			if (sushi[s] == 0)
				sum++;
			sushi[s]++;
		}
		int maxVariety = sum;
		if (sushi[c] == 0)
			maxVariety++;
		for (; sp < N; sp++) {
			int s = belt[(sp + k) % N];
			if (sushi[s] == 0)
				sum++;
			sushi[s]++;
			sushi[belt[sp]]--;
			if (sushi[belt[sp]] == 0)
				sum--;
			if (sushi[c] == 0)
				maxVariety = Math.max(maxVariety, sum + 1);
			else
				maxVariety = Math.max(maxVariety, sum);
		}
		System.out.print(maxVariety);
	}
}