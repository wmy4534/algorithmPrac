import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String H = br.readLine();
		if (H.equals("1")) {
			System.out.println(2);
		} else {
			System.out.println(1);
		}
		br.close();
	}
}
