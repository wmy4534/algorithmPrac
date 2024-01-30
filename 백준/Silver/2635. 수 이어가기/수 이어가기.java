import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		sc.close();
		StringBuilder sb = new StringBuilder();
		int maxCount = 0;
		int maxNum = 0;
		for (int i = start; i >= start/2; i--) {
			int first_num = start;
			int second_num = i;
			int count = 2;
			int third_num = first_num - second_num;
			while (third_num >= 0) {
				count++;
				first_num = second_num;
				second_num = third_num;
				third_num = first_num - second_num;
			}
			if (maxCount <= count) {
				maxCount = count;
				maxNum = i;
			}
		}
		int[] numArr = new int[maxCount];
		int first_num = start;
		int second_num = maxNum;
		int idx = 0;
		numArr[idx++] = first_num;
		numArr[idx++] = second_num;
		int third_num = first_num - second_num;
		while (third_num >= 0) {
			numArr[idx++] = third_num;
			first_num = second_num;
			second_num = third_num;
			third_num = first_num - second_num;
		}
		sb.append(maxCount + "\n");
		for (int i = 0; i < numArr.length; i++) {
			sb.append(numArr[i] + " ");
		}
		System.out.println(sb);

	}
}