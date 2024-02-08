import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		Map<String, Integer> poketmonMap = new HashMap<>();
		String[] poketmonArr = new String[N+1];
		for (int i = 1; i < N+1; i++) {
			String str = sc.next();
			poketmonMap.put(str, i);
			poketmonArr[i] = str;
		}
		
		for (int i = 0; i < M; i++) {
			if (sc.hasNextInt())
				sb.append(poketmonArr[sc.nextInt()]).append("\n");
			else {
				sb.append(poketmonMap.get(sc.next())).append("\n");
			}
		}
		System.out.println(sb);
	}
}