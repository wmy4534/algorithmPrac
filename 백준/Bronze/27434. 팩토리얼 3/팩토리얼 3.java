import java.io.*;
import java.math.BigInteger;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger answer = factorial(1, N);
        System.out.println(answer);
    }

    static BigInteger factorial(int start, int end) {
        if (start > end) return BigInteger.ONE;
        if (start == end) return BigInteger.valueOf(start);
        int mid = (start + end) / 2;
        return factorial(start, mid).multiply(factorial(mid + 1, end));
    }
}
