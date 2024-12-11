import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken()) - 1;
		long B = Long.parseLong(st.nextToken());
		long[] arr = new long[64];
		for (int i = 1; i <= 62; i++) {
			long div = 1L << i;
			arr[i] += (B / div) * (div / 2);
			arr[i] += (B % div) >= (div / 2) ? (B % div) - (div / 2) + 1 : 0;
		}
		for (int i = 1; i <= 62; i++) {
			long div = 1L << i;
			arr[i] -= (A / div) * (div / 2);
			arr[i] -= (A % div) >= (div / 2) ? (A % div) - (div / 2) + 1 : 0;
		}
		Long answer = 0L;
		for (int i = 0; i < 64; i++) {
			answer += arr[i];
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
}