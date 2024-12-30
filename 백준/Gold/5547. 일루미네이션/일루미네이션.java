import java.util.*;
import java.io.*;

public class Main {

    static int[] oddDr = { -1, -1, 1, 1, 0, 0 };
    static int[] oddDc = { 0, 1, 0, 1, -1, 1 };
    static int[] evenDr = { -1, -1, 1, 1, 0, 0 };
    static int[] evenDc = { -1, 0, -1, 0, -1, 1 };

    static boolean[][] map, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        map = new boolean[H][W];
        visited = new boolean[H][W];
        for (int r = 0; r < H; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < W; c++) {
                map[r][c] = st.nextToken().equals("1");
            }
        }
        
        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (!visited[r][c] && !map[r][c]) {
                    visited[r][c] = true;
                    List<int[]> connectedList = new ArrayList<>();
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.offer(new int[] { r, c });
                    connectedList.add(new int[] { r, c });
                    boolean isSurrounded = true;
                    while (!dq.isEmpty()) {
                        int[] tmp = dq.pollFirst();
                        if (tmp[0] % 2 == 0) {
                            for (int i = 0; i < 6; i++) {
                                int nr = oddDr[i] + tmp[0];
                                int nc = oddDc[i] + tmp[1];
                                if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                                    if (!visited[nr][nc] && !map[nr][nc]) {
                                        dq.offer(new int[] { nr, nc });
                                        connectedList.add(new int[] { nr, nc });
                                        visited[nr][nc] = true;
                                    }
                                } else {
                                    isSurrounded = false;
                                }
                            }
                        } else {
                            for (int i = 0; i < 6; i++) {
                                int nr = evenDr[i] + tmp[0];
                                int nc = evenDc[i] + tmp[1];
                                if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                                    if (!visited[nr][nc] && !map[nr][nc]) {
                                        dq.offer(new int[] { nr, nc });
                                        connectedList.add(new int[] { nr, nc });
                                        visited[nr][nc] = true;
                                    }
                                } else {
                                    isSurrounded = false;
                                }

                            }
                        }
                    }
                    if (isSurrounded) {
                        list.addAll(connectedList);
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int[] tmp = list.get(i);
            map[tmp[0]][tmp[1]] = true;
        }
        visited = new boolean[H][W];
        int answer = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (!visited[r][c] && map[r][c]) {
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.offer(new int[] { r, c });
                    visited[r][c] = true;

                    while (!dq.isEmpty()) {
                        int[] tmp = dq.pollFirst();
                        if (tmp[0] % 2 == 0) {
                            for (int i = 0; i < 6; i++) {
                                int nr = oddDr[i] + tmp[0];
                                int nc = oddDc[i] + tmp[1];
                                if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                                    if (!map[nr][nc]) {
                                        answer++;
                                    } else if (!visited[nr][nc]) {
                                        dq.offer(new int[] { nr, nc });
                                        visited[nr][nc] = true;
                                    }
                                } else {
                                    answer++;
                                }
                            }
                        } else {
                            for (int i = 0; i < 6; i++) {
                                int nr = evenDr[i] + tmp[0];
                                int nc = evenDc[i] + tmp[1];
                                if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                                    if (!map[nr][nc]) {
                                        answer++;
                                    } else if (!visited[nr][nc]) {
                                        dq.offer(new int[] { nr, nc });
                                        visited[nr][nc] = true;
                                    }
                                } else {
                                    answer++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
