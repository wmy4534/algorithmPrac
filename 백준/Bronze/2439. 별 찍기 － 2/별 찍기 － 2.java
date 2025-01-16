import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N - i; j++) {
				bw.write(" ");
			}
			for (int k = 0; k < i; k++)
				bw.write("*");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}
}