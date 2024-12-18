import java.util.*;
import java.io.*;

public class Main {
	
	static StringTokenizer st;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for (int tc = 0; tc < T; tc++) {
    		st = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		int[] arr = new int[n];
    		int[] brr = new int[m];
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < n; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < m; i++) {
    			brr[i] = Integer.parseInt(st.nextToken());
    		}
    		Arrays.sort(arr);
    		Arrays.sort(brr);
    		Map<Integer, Integer> map = new HashMap<>();
    		for (int i = 0, j = 0; i < n; i++) {
    			int a = arr[i];
    			map.put(a, Integer.MAX_VALUE);
    			for (; j < m; j++) {
    				int b = brr[j];
    				if (Math.abs(map.get(a) - a) > Math.abs(a - b)) {
    					map.replace(a, b);
    				} else {
    					j = Math.max(0, j - 1);
    					break;
    				}
    			}
    		}
    		long sum = 0L;
    		for (int i = 0; i < n; i++) {
    			long num = map.get(arr[i]);
    			if (num == Integer.MAX_VALUE) {
    				num = brr[m - 1];
    			}
    			sum += num;
    		}
    		sb.append(sum).append("\n");
    	}
    	System.out.print(sb);
    }
}