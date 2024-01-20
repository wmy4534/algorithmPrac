import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		HashSet<String> strSet = new HashSet<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int wordNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < wordNum; i++) {
			strSet.add(br.readLine());
		}
		String[] strArr = new String[strSet.size()];
		int idx = 0;
		for (String str : strSet) {
			strArr[idx++] = str;
		}

		Arrays.sort(strArr, (o1, o2) -> (o1.length() == o2.length() ? o1.compareTo(o2)
				: o1.length() - o2.length()));

		for (String str : strArr) {
			System.out.println(str);
		}
	}

}