import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] cake = new int[L+1];
		int maxWant = 0;
		int maxWantPerson = 0;
		int maxGet = 0;
		int maxGetPerson = 0;
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			if(K-P > maxWant) {
				maxWant= K-P;
				maxWantPerson = i;
			}
			int count = 0;
			for(int j = P; j <= K; j++) {
				if (cake[j] == 0) {
					cake[j]++;
					count++;
				}
			}
			if (count > maxGet) {
				maxGet = count;
				maxGetPerson = i;
			}
			
		}
		System.out.println(maxWantPerson);
		System.out.println(maxGetPerson);
	}
}