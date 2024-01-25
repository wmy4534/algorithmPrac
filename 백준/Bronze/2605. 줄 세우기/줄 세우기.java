import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int studentNum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] student = new int[studentNum];
		for (int n = 1; n <= studentNum; n++) {
			student[n - 1] = n;
		}
		for (int i = 0; i < studentNum; i++) {
			int drawNum = Integer.parseInt(st.nextToken());
			int[] tmp = Arrays.copyOfRange(student, i - drawNum, i);
			student[i - drawNum] = student[i];
			int idx = 0;
			for (int j = i - drawNum + 1; j <= i; j++) {
				student[j] = tmp[idx++];
			}
		}
		for (int s : student) {
			sb.append(s + " ");
		}
		System.out.println(sb);
	}

}