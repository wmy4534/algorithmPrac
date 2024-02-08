import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    final static int CURRENTCHANNEL = 100; // 현재 채널
    static int goalChannel;
    static List<Integer> workingButtonNum = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        goalChannel = sc.nextInt(); // 목표 채널
        int brokenButtonNum = sc.nextInt(); // 고장난 버튼 수
        for(int i = 0; i < 10; i++) { // 0부터 9까지 버튼
            workingButtonNum.add(i);
        }
        for (int i = 0; i < brokenButtonNum; i++) { // 고장난 버튼 제외
            workingButtonNum.remove(workingButtonNum.indexOf(sc.nextInt()));
        }
        int length = 0;

        int gap = Math.abs(goalChannel-CURRENTCHANNEL);
        for(int i = 0; i <= goalChannel; i++) {
            if (isPossible(goalChannel-i)) {
                if (gap > i) {
                    gap = i;
                    length = Integer.toString(goalChannel-gap).length();
                }
                break;
            }
        }
        for(int i = 0; i < gap; i++) {
            if (isPossible(goalChannel+i)) {
                gap = i;
                length = Integer.toString(goalChannel+gap).length();
                break;
            }
        }
        gap += length;
        System.out.println(Math.min(gap, Math.abs(CURRENTCHANNEL-goalChannel)));
    }

    private static boolean isPossible(int channel) {
        if (channel < 0)
            return false;
        else if(channel == 0)
            return workingButtonNum.contains(0);
        while (channel > 0) {
            int lastDigit = channel % 10;
            channel /= 10;
            boolean check = false;
            for (int i = 0; i < workingButtonNum.size(); i++) {
                if (lastDigit == workingButtonNum.get(i)) {
                    check = true;
                    break;
                }
            }
            if (!check)
                return false;
        }
        return true;
    }
}