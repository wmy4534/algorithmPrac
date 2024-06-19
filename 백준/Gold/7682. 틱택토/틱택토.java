import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 3개 연속으로 되어있거나
 * 개수가 맞지 않거나
 */
class Main {
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			map = new char[3][3];
			String str = br.readLine();
			if (str.equals("end"))
				break;
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					char tmp = str.charAt((3 * r) + c);
					map[r][c] = tmp;
				}
			}
			if (isPossible()) {
				sb.append("valid").append("\n");
			} else {
				sb.append("invalid").append("\n");
			}
		}
		System.out.print(sb);
	}

	private static boolean isPossible() {
		boolean xConti = false;
		boolean oConti = false;
		int xCnt = 0;
		int oCnt = 0;
		boolean result = true;
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (map[r][c] == '.')
					continue;
				else if (map[r][c] == 'O') {
					oCnt++;
				} else {
					xCnt++;
				}
				if (r == 0 && c == 0) {
					if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
						if (map[0][0] == 'X')
							xConti = true;
						else
							oConti = true;
					}
				}
				if (r == 0 && c == 2) {
					if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
						if (map[0][2] == 'X')
							xConti = true;
						else
							oConti = true;
					}
				}
				if (r == 0) {
					if (map[r][c] == map[1][c] && map[r][c] == map[2][c]) {
						if (map[r][c] == 'X')
							xConti = true;
						else
							oConti = true;
					}
				}
				if (c == 0) {
					if (map[r][c] == map[r][1] && map[r][c] == map[r][2]) {
						if (map[r][c] == 'X')
							xConti = true;
						else
							oConti = true;
					}
				}
			}
		}
		if (xConti && oConti || xCnt - oCnt > 1 || xCnt - oCnt < 0 || (oConti && oCnt != xCnt) || (oCnt + xCnt < 9 && !xConti && !oConti) || (xConti && xCnt != oCnt+1))
			result = false;
		return result;
	}
}