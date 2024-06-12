import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static String S;
	static String T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		int result = insert(S);
		System.out.println(result);
	}

	private static int insert(String str) {
		if (str.length() == T.length()) {
			if (str.equals(T))
				return 1;
			return 0;
		}
		int result = 0;
		String str1 = insertA(str);
		if (isInclude(str1))
			result = insert(str1);
		if (result == 1)
			return 1;
		String str2 = insertB(str);
		if (isInclude(str2))
			result = insert(str2);
		if (result == 1)
			return 1;
		return 0;
	}

	public static String reverse(String str) {
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		return result;
	}
	
	public static String insertA(String str) {
		String result = str + "A";
		return result;
	}
	
	public static String insertB(String str) {
		String result = str + "B";
		result = reverse(result);
		return result;
	}
	
	public static boolean isInclude(String str) {
		if (T.contains(str) || T.contains(reverse(str)))
			return true;
		else
			return false;
	}
	
}