import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	String N = br.readLine();
    	int max = Integer.parseInt(N);
    	int length = 0;
    	for (int i = 1; i <= max; i++) {
    		String num = Integer.toString(i);
    		sb.append(num);
    		length += num.length();
    		int idx = sb.indexOf(N);
    		if (idx >= 0) {
    			System.out.println(length - sb.length() + idx + 1);
    			return;
    		}
    		if (sb.length() > 6)
    			sb.delete(0, sb.length() - 6);
    	}
    }
}