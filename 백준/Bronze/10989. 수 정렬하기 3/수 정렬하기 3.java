import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		int[] nums = new int[10001];
		for(int i = 0; i < num; i++) {
			int input = Integer.parseInt(br.readLine());
			nums[input]++;
		}
		for(int i = 0; i < 10001; i++) {
			while(nums[i] > 0) {
				sb.append(i+"\n");
				nums[i]--;
			}
		}
		System.out.println(sb);
	}
}