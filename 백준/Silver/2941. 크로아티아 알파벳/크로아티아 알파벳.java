import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] charArr = {'=', '-', 'j'};
		int alphabetNum = str.length();
		for(int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == charArr[0]) {
				if(i >= 2 && str.charAt(i-2) == 'd' && str.charAt(i-1) == 'z') {
					alphabetNum -= 2;
				} else
					alphabetNum--;
			} else if(str.charAt(i) == charArr[1]) {
				alphabetNum--;
			}
			else if(str.charAt(i) == charArr[2]) {
				if(str.charAt(i-1) == 'l' || str.charAt(i-1) == 'n')
					alphabetNum--;
			}
		}
		System.out.println(alphabetNum);
	}
}