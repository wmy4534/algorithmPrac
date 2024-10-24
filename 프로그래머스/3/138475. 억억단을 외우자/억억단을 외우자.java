import java.util.*;
import java.io.*;

class Solution {
    int[] countArr = new int[5000001];
    
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        this.countArr[1] = 1;
        for (int i = 2; i <= 5000000; i++) {
            this.countArr[i] += 2;
            int multi = i * 2;
            while (multi <= 5000000) {
                this.countArr[multi]++;
                multi += i;
            }
        }
        
        int maxCnt = 0;
        int num = 5000000;
        for (int i = e; i > 0; i--) {
            if (this.countArr[i] >= maxCnt) { // 같아도 더 작은 수이기 때문에 갱신해준다.
                maxCnt = this.countArr[i];
                num = i;
            }
            this.countArr[i] = num;
        }
        
        for (int i = 0; i < starts.length; i++) {
            int s = starts[i];
            answer[i] = this.countArr[s];
        }
        return answer;
    }
}