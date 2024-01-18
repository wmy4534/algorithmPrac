import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] cardArr = new int[N]; // 카드 배열

		for (int i = 0; i < N; i++) {
			cardArr[i] = sc.nextInt(); // 카드 넣기
		}
		////////////////////////////////////////
		int startIdx = 0;
		Arrays.sort(cardArr);
		for (int i = 0; i < N; i++) { // 제일 큰 카드 시작 위치
			if (cardArr[i] > M/3) {
				startIdx = i-1;
				break;
			}
		}
		
		////////////////////////////////////////
		int sum = 0;
		for (int i = startIdx; i < N; i++ ) { // 제일 큰 카드
			int max = cardArr[i];
			
			for(int j = 1; j < i; j++) { // 중간 카드
				int mid = cardArr[j];
				
				for(int k = 0; k < j; k++) { // 제일 작은 카드
					int min = cardArr[k];
					
					if (sum < (max+mid+min) && (max+mid+min) <= M) {
						sum = max+mid+min;
					}
				}
			}
		}

		////////////////////////////////////////
		System.out.println(sum);
	}
}