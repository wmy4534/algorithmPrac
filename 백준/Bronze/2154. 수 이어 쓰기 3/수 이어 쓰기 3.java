import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String N = br.readLine();
    	String str = new String();
    	int max = Integer.parseInt(N);
    	int length = 0;
    	for (int i = 1; i <= max; i++) {
    		String num = Integer.toString(i);
    		length += num.length();
    		str = str.concat(num);
    		int idx = str.indexOf(N);
    		if (idx >= 0) {
    			System.out.println(length - str.length() + idx + 1);
    			return;
    		}
    		str = str.substring(Math.max(0, str.length() - 6));
    	}
    }
}