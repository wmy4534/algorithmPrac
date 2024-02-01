import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int siteNum = Integer.parseInt(st.nextToken());
		int findNum = Integer.parseInt(st.nextToken());
		Map<String, String> map = new HashMap();
		for(int s = 0; s < siteNum; s++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		for(int i = 0; i < findNum; i++) {
			String site = br.readLine();
			sb.append(map.get(site)).append("\n");
		}
		System.out.println(sb);
	}
}