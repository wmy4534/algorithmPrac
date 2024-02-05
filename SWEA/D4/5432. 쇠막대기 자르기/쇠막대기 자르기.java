import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			Stack<Character> stack = new Stack<>();
			char[] c = (br.readLine()).toCharArray();
			int result = 0;
			for(int i = 0; i < c.length; i++) {
				if (c[i] == '(') {
					stack.push(c[i]);
				} else if (c[i-1] == '(') {
					stack.pop();
					result += stack.size();
				} else {
					stack.pop();
					result++;
				}
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb);
	}
}