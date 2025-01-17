import java.util.*;
import java.io.*;

public class Main {

	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String[] strArr = br.readLine().split(" ");
			int num1 = Integer.parseInt(strArr[0]);
			int num2 = Integer.parseInt(strArr[1]);
			int num3 = Integer.parseInt(strArr[2]);
			if (num1 == 0 && num2 == 0 && num3 == 0)
				break;
			int num4 = 0;
			if (num3 - num2 == num2 - num1) {
				num4 = num3 + (num3 - num2);
				bw.write("AP " + num4);
			} else {
				num4 = num3 * (num3 / num2);
				bw.write("GP " + num4);
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
