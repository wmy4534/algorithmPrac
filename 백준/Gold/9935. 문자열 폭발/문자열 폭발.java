import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String explosionStr = br.readLine();
        int explosionLength = explosionStr.length();
        char[] chars = new char[explosionLength];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < explosionLength-1; i++) {
            stack.push(str.charAt(i));
        }
        for (int i = explosionLength-1; i < str.length(); i++) {
            if (str.charAt(i) == explosionStr.charAt(explosionLength-1)) {
                chars[explosionLength-1] = str.charAt(i);
                for (int idx = explosionLength-2; idx >= 0; idx--) {
                    if (stack.isEmpty()) {
                        for (int readd = idx+1; readd < explosionLength; readd++) {
                            stack.push(chars[readd]);
                        }
                        break;
                    }
                    chars[idx] = stack.pop();
                    if (chars[idx] == explosionStr.charAt(idx)) {
                        continue;
                    } else {
                        for (int readd = idx; readd < explosionLength; readd++) {
                            stack.push(chars[readd]);
                        }
                        break;
                    }
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            for (char c : stack) {
                sb.append(c);
            }
        }
        System.out.print(sb);
    }
}