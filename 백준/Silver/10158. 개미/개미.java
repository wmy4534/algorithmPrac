import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int time = Integer.parseInt(br.readLine());
		x += time;
		y += time;
		
		if((x / width)%2 == 1) {
			sb.append(width-x%width+" ");
		} else {
			sb.append(x%width+" ");
		}
		if((y/height) % 2 == 1) {
			sb.append(height-y%height);
		} else {
			sb.append(y%height);
		}
		System.out.println(sb);
	}
}