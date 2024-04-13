import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] prices = new int[N]; // 방 번호 가격
		String firstNum = "0"; // 첫 자리에 들어갈 숫자
		String minNum = "0"; // 두 번째 자리부터 쓰일 숫자
		int firstPrice = 50; // 첫 자리에 들어갈 숫자 가격
		int minPrice = 50; // 두 번째 자리부터 들어가는 숫자 가격
		for (int i = 0; i < N; i++) {
			prices[i] = sc.nextInt();
			if (prices[i] <= firstPrice && i > 0) { // 0은 맨 앞자리가 될 수 없으므로 0이 아닌 수부터 측정
				firstNum = Integer.toString(i);
				firstPrice = prices[i];
			}
			if (prices[i] <= minPrice) {
				minNum = Integer.toString(i);
				minPrice = prices[i];
			}
		}
		String maxNum = "";
		int M = sc.nextInt(); // 쓸 수 있는 총 금액
		if (M >= firstPrice) {
			M -= firstPrice; // 첫 자리는 0이 아닌 수
			maxNum += firstNum;
		} else { // 첫 자리에 쓸 수 있는 수가 없으면
			System.out.print(0);
			return;
		}
		int cnt = 1; // 숫자 1
		while (M >= minPrice) {
			M -= minPrice;
			cnt++;
			maxNum += minNum;
		}
		String result = "";
		for (int i = 0; i < cnt; i++) {
			if (i == 0) {
				for (int idx = N - 1; idx >= Integer.parseInt(firstNum); idx--) {
					if (M >= prices[idx] - firstPrice) {
						result += idx;
						M -= (prices[idx] - firstPrice);
						break;
					}
				}
			} else {
				for (int idx = N - 1; idx >= Integer.parseInt(minNum); idx--) {
					if (M >= prices[idx] - minPrice) {
						result += idx;
						M -= (prices[idx] - minPrice);
						break;
					}
				}
			}
		}
		System.out.print(result);
	}
}