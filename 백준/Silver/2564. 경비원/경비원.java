import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int storeNum = Integer.parseInt(br.readLine());
		int[][] store = new int[storeNum][2];
		for(int t = 0; t < storeNum; t++) {
			st = new StringTokenizer(br.readLine());
			store[t][0] = Integer.parseInt(st.nextToken());
			store[t][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int location = Integer.parseInt(st.nextToken());
		int far = Integer.parseInt(st.nextToken());
		int sum = 0;
		for(int i = 0; i < storeNum; i++) {
			switch (location) {
			case 1:
				if (store[i][0] == 3) {
					sum += far + store[i][1]; 
				} else if (store[i][0] == 4) {
					sum += (width-far) + store[i][1];
				} else if (store[i][0] == 1) {
					sum += Math.abs(store[i][1]-far);
				} else {
					sum += Math.min(far+store[i][1], (width-far)+(width-store[i][1]))+height;
				}
				break;
			case 2:
				if (store[i][0] == 3) {
					sum += far + (height-store[i][1]); 
				} else if (store[i][0] == 4) {
					sum += (width-far) + (height-store[i][1]);
				} else if (store[i][0] == 2) {
					sum += Math.abs(store[i][1]-far);
				} else {
					sum += (Math.min(far+store[i][1], (width-far)+(width-store[i][1]))+height);
				}
				break;
			case 3:
				if (store[i][0] == 1) {
					sum += far + store[i][1]; 
				} else if (store[i][0] == 2) {
					sum += (height-far) + store[i][1];
				} else if (store[i][0] == 3) {
					sum += Math.abs(store[i][1]-far);
				} else {
					sum += Math.min(far+store[i][1], (height-far)+(height-store[i][1]))+width;
				}
				break;
			case 4:
				if (store[i][0] == 1) {
					sum += far + (width-store[i][1]); 
				} else if (store[i][0] == 2) {
					sum += (height-far) + (width-store[i][1]);
				} else if (store[i][0] == 4) {
					sum += Math.abs(store[i][1]-far);
				} else {
					sum += Math.min(far+store[i][1], (height-far)+(height-store[i][1]))+width;
				}
				break;
			}
		}
		System.out.println(sum);
	}
}