import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 자료의 수
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken(); // 문제 제목
			int I = Integer.parseInt(st.nextToken()); // 문제 번호
			int D = Integer.parseInt(st.nextToken()); // 난이도
			char c = Character.toUpperCase(s.charAt(D - 1));
			arr[i][0] = I;
			arr[i][1] = c;
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for (int i = 0; i < N; i++) {
			sb.append((char)arr[i][1]);
		}
		
		System.out.println(sb);
		br.close();
	}
	
}
