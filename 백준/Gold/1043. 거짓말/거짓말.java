import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int personNum = Integer.parseInt(st.nextToken());
        int partyNum = Integer.parseInt(st.nextToken());
        boolean[] truth = new boolean[personNum+1];
        st = new StringTokenizer(br.readLine());
        int numOfTruth = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numOfTruth; i++) {
            int idx = Integer.parseInt(st.nextToken());
            truth[idx] = true;
        }
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int t = 1; t <= partyNum; t++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] tmp = new int[num];
            for (int i = 0; i < num; i++) {
                tmp[i] = Integer.parseInt(st.nextToken());
            }
            queue.offer(tmp);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll().clone();
                boolean check = false; // 진실을 아는 사람이 있는지 체크
                for (int j = 0; j < tmp.length; j++) {
                    if (truth[tmp[j]]) {
                        check = true;
                        break;
                    }
                }
                if (check) {
                    for (int k = 0; k < tmp.length; k++) {
                        truth[tmp[k]] = true;
                    }
                } else {
                    queue.offer(tmp);
                }
            }
            if (size == queue.size()) {
                cnt = size;
                break;
            }
        }
        System.out.print(cnt);
    }
}