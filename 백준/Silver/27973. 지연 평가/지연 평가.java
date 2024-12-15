import java.io.*;
import java.util.*;

class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long num = 1L;
	static long multiply = 1L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Q = Integer.parseInt(br.readLine()); // 명령의 수
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 1:
				long x = Long.parseLong(st.nextToken()); // 곱하기
				num *= x;
				multiply *= x;
				break;
			case 2:
				long n = Long.parseLong(st.nextToken()); // 작은 원소 n개 제거
				num += n * multiply;
				break;
			case 3:
				sb.append(num).append("\n");
				break;
			case 0:
				x = Integer.parseInt(st.nextToken()); // 더하기
				num += x;
				break;
			}
		}
		System.out.print(sb);
	}
}
