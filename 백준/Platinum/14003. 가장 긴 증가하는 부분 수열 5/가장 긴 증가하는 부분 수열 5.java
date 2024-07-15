import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> lis = new ArrayList<Integer>();
		arr[0] = Integer.parseInt(st.nextToken());
		lis.add(arr[0]);
		int[] idxs = new int[N];
		idxs[0] = 1;
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int idx = Collections.binarySearch(lis, arr[i]);
			if (idx < 0)
				idx = -(idx + 1);
			idxs[i] = idx+1;
			if (idx >= lis.size())
				lis.add(arr[i]);
			else
				lis.set(idx, arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		int num = lis.size();
		sb.append(num).append("\n");
		int[] tmp = new int[lis.size()];
		for (int i = N-1; i >= 0; i--) {
			if (idxs[i] == num) {
				tmp[num-1] = arr[i];
				num--;
				if (num <= 0)
					break;
			}
		}
		for (int i = 0; i < tmp.length; i++) {
			sb.append(tmp[i]).append(" ");
		}
		System.out.print(sb);
	}
}