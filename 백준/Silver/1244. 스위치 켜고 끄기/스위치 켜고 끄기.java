import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int switchNum = Integer.parseInt(br.readLine());
		int[] switchMap = new int[switchNum + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= switchNum; i++) {
			switchMap[i] = Integer.parseInt(st.nextToken());
		}
		int studentNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int cardNum = Integer.parseInt(st.nextToken());
			if (gender == 1) {
				for (int j = 1; j <= switchNum; j++) {
					if (j % cardNum == 0 && switchMap[j] == 0)
						switchMap[j] = 1;
					else if (j % cardNum == 0 && switchMap[j] == 1)
						switchMap[j] = 0;
				}
			} else {
				int moveGap = 0;
				for (int j = 1; j <= Math.min(cardNum - 1, switchNum - cardNum); j++) {
					if (switchMap[cardNum - j] == switchMap[cardNum + j]) {
						moveGap = j;
					} else
						break;
				}
				for (int k = cardNum - moveGap; k <= cardNum + moveGap; k++) {
					if (switchMap[k] == 1)
						switchMap[k] = 0;
					else
						switchMap[k] = 1;
				}
			}
		}
		int repeat = switchNum/20;
		if(switchNum%20==0) {
			repeat--;
		}
		for(int r = 0; r <= repeat; r++) {
			for(int i = 1+20*r; i <= Math.min(20*(r+1), switchNum); i++) {
				sb.append(switchMap[i] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}