import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // 음의 개수
    	int A = Integer.parseInt(st.nextToken()); // 첫 항
    	int D = Integer.parseInt(st.nextToken()); // 공차
    	int[] arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	int num = A;
    	int answer = 0;
    	for (int i = 0; i < N; i++) {
    		if (arr[i] == num) {
    			answer++;
    			num += D;
    		}
    	}
    	System.out.println(answer);
    }
}
