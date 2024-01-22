import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int result = 0;
		for(int i = 1; i <= 10; i++) {
			sum += Integer.parseInt(br.readLine());
			if (Math.abs(100-sum) <= Math.abs(100-result))
				result = sum;
			if (sum >= 100)
				break;
		}
		System.out.println(result);
	}

}