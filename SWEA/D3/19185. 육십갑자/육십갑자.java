import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			String[] firstNames = new String[first];
			String[] secondNames = new String[second];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < first; i++) {
				firstNames[i] = st.nextToken();
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < second; i++) {
				secondNames[i] = st.nextToken();
			}
			
			int yearNum = Integer.parseInt(br.readLine());
			
			for(int y = 0; y < yearNum; y++) {
				String yearName = "";
				int year = Integer.parseInt(br.readLine());
				yearName += firstNames[(year-1)%first];
				yearName += secondNames[(year-1)%second];
				sb.append(yearName).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}