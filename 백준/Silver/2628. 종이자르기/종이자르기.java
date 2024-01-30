import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int countNum = Integer.parseInt(br.readLine());
		ArrayList<Integer> horizonList = new ArrayList<>();
		horizonList.add(width);
		horizonList.add(0);
		ArrayList<Integer> verticalList = new ArrayList<>();
		verticalList.add(height);
		verticalList.add(0);
		for(int i = 0; i < countNum; i++) {
			st = new StringTokenizer(br.readLine());
			int horizonCheck = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			if(horizonCheck == 1) // 세로로 자르면 가로가 늘어남
				horizonList.add(point);
			else // 가로로 자르면 세로가 늘어남
				verticalList.add(point);
		}
		horizonList.sort(Comparator.reverseOrder());
		verticalList.sort(Comparator.reverseOrder());
		
		int maxVertical = 0;
		int maxHorizon = 0;
		for(int i = 1; i < horizonList.size(); i++) {
			if(horizonList.get(i-1)-horizonList.get(i) > maxHorizon)
				maxHorizon = horizonList.get(i-1)-horizonList.get(i);
		}
		for(int i = 1; i < verticalList.size(); i++) {
			if(verticalList.get(i-1)-verticalList.get(i) > maxVertical)
				maxVertical = verticalList.get(i-1)-verticalList.get(i);
		}
		System.out.println(maxHorizon*maxVertical);
	}
}