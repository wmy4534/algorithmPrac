import java.util.*;
import java.io.*;

public class Main {

	static String noCase = "Goldbach's conjecture is wrong.";
	static final int MAX = 1000001;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] primeArr = new boolean[MAX];
		primeArr[0] = true;
		primeArr[1] = true;
		
		for (int i = 2; i < MAX; i++) {
			if (!primeArr[i]) {
				set.add(i);
				for (int j = 2; i * j < MAX; j++) {
					primeArr[i * j] = true;
				}
			}
		}
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			boolean isPossible = false;
			for (int i = 3; i < n; i++) {
				if (primeArr[i])
					continue;
				int num = n - i;
				if (set.contains(num)) {
					bw.write(n + " = " + i + " + " + num + "\n");
					isPossible = true;
					break;
				}
			}
			if (!isPossible)
				bw.write(noCase + "\n");
		}
		bw.flush();
		bw.close();
	}
}