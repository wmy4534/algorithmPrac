import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] xy = new int[N][2]; // 좌표 배열
		long[] countX = new long[100001]; // 좌표 x의 카운트 배열
		long[] countY = new long[100001]; // 좌표 y의 카운트 배열
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			xy[i][0] = x; // 입력받은 좌표를 배열에 넣고
			xy[i][1] = y;
			countX[x]++; // 카운트 배열을 늘려준다
			countY[y]++;
		}
		long numOfTriangle = 0; // 총 삼각형의 개수
		for (int i = 0; i < N; i++) {
			numOfTriangle += (countX[xy[i][0]]-1)*(countY[xy[i][1]]-1); // 좌표 배열에서 하나씩 꺼내서 카운트를 비교
		}
		System.out.println(numOfTriangle);
	}
}