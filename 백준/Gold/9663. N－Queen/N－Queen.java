import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] location = new int[N + 1];
        int count = 0;
        count = possibleLocation(location, 1, N, count);
        System.out.println(count);
    }


    private static int possibleLocation(int[] location, int r, int N, int count) {
        if (r > N) {
            count++;
            return count;
        }

        for (int c = 1; c <= N; c++) { // 퀸이 놓일 수 있는 열 위치
            location[r] = c;
            if (possible(location, r)) {
                count = possibleLocation(location, r+1, N, count);
            }
            location[r] = 0;
        }
        return count;
    }

    private static boolean possible(int[] location, int r) {
        for (int i = 1; i < r; i++) {
            if (location[i] == location[r] || Math.abs(location[i]-location[r]) == r - i) {
                return false;
            }
        }
        return true;
    }
}