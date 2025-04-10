import java.util.*;
import java.io.*;

public class Main {

	
	static int[] fibo;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		fib(n);
		System.out.println(count + " " + (n - 2));
		br.close();
	}
	
	public static int fib(int n) {
		if (n == 1 || n == 2) {
			count++;
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
	
}
