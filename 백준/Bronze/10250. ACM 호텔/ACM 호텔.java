import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int floor = (N % H == 0) ? H : N % H;  // 층 수
			int room = (N % H == 0) ? N / H : N / H + 1;  // 호수

			int hotel = floor * 100 + room;
			sb.append(hotel).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
