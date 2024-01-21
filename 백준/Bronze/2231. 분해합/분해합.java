import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] r = new int[7];
		int num = N;
		int q = 0;
		for(int i = 0; num > 0; num/=10, i++ ) {
			r[i] = num%10;
			q = i;
		}
		int min = 0;
		if (q == 0) {
			min = 1;
		} else if (r[q] == 1 && (q==1 || q==2)) {
			min = 8*(int)Math.pow(10, q-1);
		} else if (r[q] == 1) {
			min = 9*(int)Math.pow(10, q-1);
		} else {
			min = (r[q]-1)*(int)Math.pow(10, q);
		}
		boolean check = true;
		for (int i = min; i < N; i++) {
			int sum = i;
			for (int j = i; j > 0; j/=10) {
				sum += j%10;
			}
			if(sum == N) {
				System.out.println(i);
				check = false;
				break;
			}
		}
		if(check) {
			System.out.println(0);
		}
		
	}
}