import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 수열의 개수
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>(); // set 도 되고, count 배열도 될 듯, 만약 시간 초과가 뜬다면 count 배열로 하는게 더 빠를 수 있음.
		// set은 겹치지 않는 숫자만을 위해서 넣음
		int lpointer = 0;
		long result = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			if (set.contains(num)) {
				while (arr[lpointer] != num) {
					set.remove(arr[lpointer++]);
				}
				lpointer++; // 그 전에 num이 나온 위치이므로 한 칸 더 움직인다.
			}
			set.add(num);
			result += set.size();
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}