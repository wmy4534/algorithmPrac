import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarfArr = new int[9];
		int totalSum = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			dwarfArr[i] = Integer.parseInt(br.readLine());
			totalSum += dwarfArr[i];
		}
		int gap = totalSum - 100;
		Loop:
		for(int i = 1; i < 9; i++) {
			for(int j = 0; j < i; j++) {
				if(dwarfArr[i]+dwarfArr[j] == gap) {
					dwarfArr[i] = -1;
					dwarfArr[j] = -1;
					break Loop;
				}
			}
		}
		
		Arrays.sort(dwarfArr);
		for(int i = 2; i < 9; i++) {
			sb.append(dwarfArr[i]+"\n");
		}
		System.out.println(sb);
		
	}
}