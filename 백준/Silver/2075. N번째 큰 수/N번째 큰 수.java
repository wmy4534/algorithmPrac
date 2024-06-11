import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N];
		
		for (int c = 0; c < N; c++) {
			arr[0][c] = Integer.MIN_VALUE;
		}
		for (int r = 1; r <= N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[2]-o1[2];
			}
			
		});
		
		for (int c = 0; c < N; c++) {
			pq.offer(new int[] {N, c, arr[N][c]});
		}
		
		while (N > 1) {
			int[] tmp = pq.poll();
			pq.offer(new int[] {tmp[0]-1, tmp[1], arr[tmp[0]-1][tmp[1]] });
			N--;
		}
		
		int Nth = pq.poll()[2];
		System.out.println(Nth);
	}
}