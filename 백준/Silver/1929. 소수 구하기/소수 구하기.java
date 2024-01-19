import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] primeNum = new boolean[M+1];
		primeNum[0] = true;
		primeNum[1] = true;
		for(int i=2; i<M; i++) {
			for(int j=2; j<(M/i)+1; j++) {
				primeNum[i*j] = true;
			}
		}
		for(int i = N; i<=M; i++) {
			if(!primeNum[i])
				sb.append(i+"\n");
		}
		System.out.println(sb);
	}
}