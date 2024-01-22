import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int i = 1; i <= tc; i++) {
			String input = br.readLine();
			int stickNum = 0;
			int sum = 0;
			for(int j = 0; j < input.length(); j++) {
				if (input.codePointAt(j) == '(') {
					stickNum++;
				} else if(input.codePointAt(j) == ')' && input.codePointAt(j-1) == '(') {
					stickNum--;
					sum += stickNum;
				} else if(input.codePointAt(j) == ')') {
					stickNum--;
					sum++;
				}
			}
			sb.append("#"+i+" "+sum+"\n");		
		}
		System.out.println(sb);
	}
}