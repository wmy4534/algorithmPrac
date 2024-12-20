import java.util.*;
import java.io.*;

public class Main {
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	long result = 0L;
    	long num = 1L;
    	long idx = 2L;
    	TreeMap<Long, Long> map = new TreeMap<>();
    	while (result <= 1000000000L) {
    		result = (num * ++num) / 2;
    		double root = Math.sqrt(result + 1);
    		if (root == (long) root)
    			map.put(result + 1, idx++);
    	}
    	int tc = 1;
    	while (true) {
    	st = new StringTokenizer(br.readLine());
    	long a = Long.parseLong(st.nextToken());
    	long b = Long.parseLong(st.nextToken());
    	if (a == 0 && b == 0)
    		break;
    	sb.append("Case " + (tc++) + ": ");
    	Long max = map.floorKey(b - 1);
    	Long min = map.ceilingKey(a + 1);
    	long count = 0;
    	if (min != null && max != null && min <= max ) {
    		count = map.get(max) - map.get(min) + 1;
    	}
    	sb.append(count);
    	sb.append("\n");
    	}
    	
    	System.out.print(sb);
    }
}