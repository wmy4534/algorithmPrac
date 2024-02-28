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
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int wearNum = Integer.parseInt(br.readLine());
			String[][] wears = new String[wearNum][2];
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < wearNum; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				wears[i][0] = st.nextToken();
				wears[i][1] = st.nextToken();
				if (map.containsKey(wears[i][1])) {
					map.replace(wears[i][1], map.get(wears[i][1]) + 1);
				} else {
					map.put(wears[i][1], 1);
				}
			}
			int result = 1;
			for (String str : map.keySet()) {
				result *= (map.get(str) + 1);
			}
			result -= 1;
			System.out.println(result);
		}
	}
}