import java.util.*;
import java.io.*;

public class Main {
    static int V;
    static List<int[]>[] list;
    static boolean[] visited;
    static int start;
    static int maxDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }
                int dist = Integer.parseInt(st.nextToken());
                list[v].add(new int[]{num, dist});
            }
        }
        visited[1] = true;
        dfs(1, 0);
        visited = new boolean[V + 1];
        visited[start] = true;
        dfs(start, 0);
        System.out.println(maxDist);

    }

    private static void dfs(int s, int dist) {
        if (dist > maxDist) {
            maxDist = dist;
            start = s;
        }
        for (int[] arr : list[s]) {
            if (visited[arr[0]])
                continue;
            visited[arr[0]] = true;
            dfs(arr[0], dist + arr[1]);
        }
    }

}