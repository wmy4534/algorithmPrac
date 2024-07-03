import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (map.containsValue(str))
				continue;
			map.put(str, i);
		}
		List<String> list = new ArrayList<>(map.keySet());
		List<String[]> commonList = new ArrayList<>();
		int maxLen = 0;
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			String S = list.get(i);
			if (S.length() < maxLen)
				continue;
			for (int j = i + 1; j < list.size(); j++) {
				String T = list.get(j);
				if (T.length() < maxLen)
					continue;
				if (T.charAt(0) == S.charAt(0) && T.substring(0, maxLen).equals(S.substring(0, maxLen))) {
					int len = maxLen;
					for (; len < Math.min(S.length(), T.length()); len++) {
						if (S.charAt(len) == T.charAt(len))
							continue;
						else {// 문자열이 일치하지 않을 때
							break;
						}
					}
					if (len > maxLen) { // 최대 길이가 더 길어졌다면 리스트 초기화 후 삽입
						commonList = new ArrayList<>();
						if (map.get(S) < map.get(T))
							commonList.add(new String[] { S, T });
						else
							commonList.add(new String[] { T, S });
						maxLen = len;
					} else if (len == maxLen) { // 최대 길이가 같다면 그 땐 다시 비교
						if (map.get(S) < map.get(T))
							commonList.add(new String[] { S, T });
						else
							commonList.add(new String[] { T, S });
					}
				} else {
					break;
				}
			}
		}
		Collections.sort(commonList, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return map.get(o1[0]) == map.get(o2[0]) ? map.get(o1[1]) - map.get(o2[1]) : map.get(o1[0]) - map.get(o2[0]);
			}

		});
		System.out.println(commonList.get(0)[0] + "\n" + commonList.get(0)[1]);
	}
}