import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 마을 수
		int C = Integer.parseInt(st.nextToken()); // 트럭 용량
		int M = Integer.parseInt(br.readLine()); // 보내는 박스 정보의 수
		int[][] boxes = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			boxes[i][0] = Integer.parseInt(st.nextToken()); // 보내는 마을
			boxes[i][1] = Integer.parseInt(st.nextToken()); // 받는 마을
			boxes[i][2] = Integer.parseInt(st.nextToken()); // 박스 수
		}

		Arrays.sort(boxes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
			}

		});

		int[] truck = new int[N + 1];
		int max, possible, total = 0;
		for (int i = 0; i < M; i++) {
			max = 0;
			for (int j = boxes[i][0]; j < boxes[i][1]; j++) {
				max = Math.max(max, truck[j]);
			}

			possible = Math.min(C - max, boxes[i][2]);
			total += possible;
			for (int j = boxes[i][0]; j < boxes[i][1]; j++) {
				truck[j] += possible;
			}
		}
		
		System.out.println(total + truck[N]);
	}
}