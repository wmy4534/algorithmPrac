class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int playTime = stringToTime(video_len);
        int currentTime = stringToTime(pos);
        int opStart = stringToTime(op_start);
        int opEnd = stringToTime(op_end);
        if (currentTime >= opStart && currentTime < opEnd) {
            currentTime = opEnd;
        }
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command) {
                case "prev":
                    currentTime -= 10;
                    break;
                case "next":
                    currentTime += 10;
                    break;
            }
            if (currentTime < 0) {
                currentTime = 0;
            } else if (currentTime > playTime) {
                currentTime = playTime;
            }
            if (currentTime >= opStart && currentTime < opEnd) {
                currentTime = opEnd;
            }
        }
        answer += String.format("%02d", currentTime / 60) + ":";
        answer += String.format("%02d", currentTime % 60);
        return answer;
    }
    
    public int stringToTime(String str) {
        String[] arr = str.split(":");
        int minutes = Integer.parseInt(arr[0]);
        int seconds = Integer.parseInt(arr[1]);
        return minutes * 60 + seconds;
    }
}