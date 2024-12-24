import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE / 16;
    private static int N;
    private static Deque<String> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input(br);

        bw.write(String.valueOf(solve()));
        bw.close();
    }

    private static int solve() {
        return DFS("", 0);
    }

    private static int DFS(String current, int depth) {
        if (depth == N) {
            return current.length();
        }

        int minLen = INF;
        for (int i = depth; i < N; i++) {
            String temp = deque.pollFirst();
            int matchLen = check(current, temp);
            minLen = Math.min(minLen, DFS(current + temp.substring(matchLen), depth + 1));
            deque.offerLast(temp);
        }

        return minLen;
    }

    private static int check(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        int min = Math.min(aLen, bLen);
        for (int i = min; i > 0; i--) {
            if (a.substring(aLen - i).equals(b.substring(0, i))) {
                // substring이 모두 일치하면 일치하는 최대 길이 반환
                return i;
            }
        }

        return 0;
    }

    private static void input(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            deque.offer(br.readLine());
        }
    }
}