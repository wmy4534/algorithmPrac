import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int N = Integer.parseInt(br.readLine());
    	int M = 0;
    	if (N > 1) {
    		M = N * 2 - 2;
    		sb.append(M).append("\n");
    		for (int i = 1; i <= N; i++) {
    			sb.append(i).append(" ").append(1).append("\n");
    		}
    		for (int i = 2; i < N; i++) {
    			sb.append(i).append(" ").append(N).append("\n");
    		}
    	} else {
    		M = 1;
    		sb.append(M).append("\n");
    		sb.append(1).append(" ").append(1);
    	}
    	System.out.print(sb);
    }
}