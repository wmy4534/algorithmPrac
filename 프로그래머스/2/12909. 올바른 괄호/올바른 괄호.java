import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                dq.offerLast(c);
            else {
                if (dq.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    char tmp = dq.pollLast();
                    if (tmp != '(') {
                        answer = false;
                        break;
                    }
                }
            }
        }
        if (!dq.isEmpty())
            answer = false;
        return answer;
    }
}