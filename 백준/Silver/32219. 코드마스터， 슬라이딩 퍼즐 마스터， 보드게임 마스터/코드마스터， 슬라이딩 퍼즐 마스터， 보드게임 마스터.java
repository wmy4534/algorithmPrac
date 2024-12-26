import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int tc = Integer.parseInt(br.readLine());
    	for (int t = 0; t < tc; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int r = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		if (r == 1 || c == 1) {
    			if (r == c) {
    				sb.append("dohoon").append("\n");
    				continue;
    			}
    			sb.append("jinseo").append("\n");
    			sb.append(1 + " " + 1).append("\n");
    		} else if (r == c) {
    			sb.append("dohoon").append("\n");
    		} else {
    			sb.append("jinseo").append("\n");
    			sb.append(Math.min(r, c) + " " + Math.min(r, c)).append("\n");
    		}
    	}
    	br.close();
    	System.out.print(sb);
    }
}
