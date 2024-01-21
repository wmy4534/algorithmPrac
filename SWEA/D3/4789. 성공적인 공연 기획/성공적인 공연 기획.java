import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			String str = br.readLine();
			int sumOfAudience = 0;
			int moreAudience = 0;
			for (int idx = 0; idx < str.length(); idx++) {
				if (sumOfAudience < idx) {
					moreAudience += idx-sumOfAudience;
					sumOfAudience += idx-sumOfAudience;
				}
				sumOfAudience += (int)(str.charAt(idx)-'0');
			}
//			sb.append("#"+t+" "+moreAudience+"\n");
			System.out.println("#"+t+" "+moreAudience);
		}
//		System.out.println(sb);
	}
}