import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] neverHeardPerson = new String[N];
		String[] neverSeenPerson = new String[M];
		for (int n = 0; n < N; n++) {
			neverHeardPerson[n] = br.readLine();
		}
		for (int m = 0; m < M; m++) {
			neverSeenPerson[m] = br.readLine();
		}
		String[] everyPerson = new String[N+M];
		List<String> neverSeenHeardPerson = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			everyPerson[i] = neverHeardPerson[i];
		}
		for (int i = N; i < N+M; i++) {
			everyPerson[i] = neverSeenPerson[i-N];
		}
		Arrays.sort(everyPerson);
		for (int i = 0; i < N+M-1; i++) {
			if (everyPerson[i].equals(everyPerson[i+1])) {
				neverSeenHeardPerson.add(everyPerson[i++]);
			}
		}
		sb.append(neverSeenHeardPerson.size()).append("\n");
		for (int i = 0; i < neverSeenHeardPerson.size(); i++) {
			sb.append(neverSeenHeardPerson.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}