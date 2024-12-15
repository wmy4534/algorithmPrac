import java.io.*;
import java.util.*;

class Main {
	final static String[] answer = {"Yes", "No"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			list.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.get(i % k).add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < k; i++) {
			Collections.sort(list.get(i));
		}
		
		int[] arr = new int[N];
		for (int i = 0; i < k; i++) {
			for (int n = 0; n*k+i < N; n++) {
				arr[n*k+i] = list.get(i).get(n);
			}
		}
		byte num = 0;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				num = 1;
				break;
			}
		}
		
		System.out.println(answer[num]);
	}
}
