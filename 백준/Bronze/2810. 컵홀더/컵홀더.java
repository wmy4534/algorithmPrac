import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int chairNum = Integer.parseInt(br.readLine());
		int cupHolderNum = 1;
		String seatMap = br.readLine();
		int coupleCheck = 0;
		for(int i = 0; i < chairNum; i++) {
			if (seatMap.charAt(i) == 'S') {
				cupHolderNum++;
			}
			else if (seatMap.charAt(i) == 'L') {
				coupleCheck++;
				if(coupleCheck %2== 0) {
					coupleCheck = 0;
					cupHolderNum++;
				}
			}
		}
		System.out.println(Math.min(chairNum, cupHolderNum));
	}
}