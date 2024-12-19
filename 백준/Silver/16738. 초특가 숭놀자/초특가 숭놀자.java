import java.util.*;
import java.io.*;

public class Main {
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int Q = Integer.parseInt(st.nextToken());
    	int[][] rooms = new int[N + 1][2];
    	List<Integer> history = new ArrayList<>();
    	history.add(null);
    	for (int command = 0; command < Q; command++) {
    		st = new StringTokenizer(br.readLine());
    		String str = st.nextToken();
    		switch (str) {
    		case "new":
    			int num = Integer.parseInt(st.nextToken());
    			int extent = Integer.parseInt(st.nextToken());
    			int count = 0;
    			for (int i = 1; i <= N; i++) {
    				if (rooms[i][0] == 0) {
    					count++;
    					if (count == extent) {
    						rooms[i - extent + 1][0] = i;
    						rooms[i - extent + 1][1] = num;
    						history.add(i - extent + 1);
    						sb.append(i - extent + 1 + " " + i).append("\n");
    						break;
    					}
    				} else {
    					count = 0;
    					i = rooms[i][0];
    				}
    			}
    			if (count != extent) {
    				sb.append("REJECTED").append("\n");
    			}
    			break;
    		case "in":
    			int order = Integer.parseInt(st.nextToken());
    			num = Integer.parseInt(st.nextToken());
    			int idx = history.get(order);
    			rooms[idx][1] += num;
    			break;
    		case "out":
    			order = Integer.parseInt(st.nextToken());
    			num = Integer.parseInt(st.nextToken());
    			idx = history.get(order);
    			int right = rooms[idx][0];
    			rooms[idx][1] -= num;
    			if (rooms[idx][1] == 0) {
    				rooms[idx][0] = 0;
    				sb.append("CLEAN " + idx + " " + right).append("\n");
    			}
    			break;
    		}
    	}
    	System.out.print(sb);
    }
}