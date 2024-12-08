class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int length = diffs.length;
        int left = 1;
        int right = 100000;
        while (left <= right) {
            int level = (left + right) / 2;
            long time = 0;
            for (int i = 0; i < length; i++) {
                int diff = diffs[i];
                int time_cur = times[i];
                if (diff <= level) {
                    time += time_cur;
                } else {
                    time += (diff - level) * (i == 0 ? time_cur : times[i - 1] + time_cur) + time_cur;
                }
            }
            if (time <= limit) {
                right = level - 1;
                answer = level;
            } else {
                left = level + 1;
            }
        }
        return answer;
    }
}