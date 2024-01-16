import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] gradeArr = new int[n];
		int max = 0;
		for(int i = 0; i<n; i++) {
			gradeArr[i] = sc.nextInt();
			if (max < gradeArr[i]) {
				max = gradeArr[i];
			}
		}
		double gradeSum = 0;
		for(int grade : gradeArr) {
			gradeSum += ((double)grade/max)*100.0;
		}
		double gradeAverage = gradeSum/n;
		System.out.println(gradeAverage);
	}

}