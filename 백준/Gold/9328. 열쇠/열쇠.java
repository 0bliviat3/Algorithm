import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { // 좀더 고민해볼것
    public static void main(String[] args) {
        new BOJ9328Sol(new ArrayDeque<>()).run();
    }
}

class Point9328 {
    int x;
    int y;

    Point9328(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class BOJ9328Sol {

    private char[][] map;
    private boolean[][] visit;
    private boolean[] keys;
    private List<List<Point9328>> doors;
    private final Queue<Point9328> queue;
    private final int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private int cnt;

    BOJ9328Sol(final Queue<Point9328> queue) {
        this.queue = queue;
    }

    private void clearMap(int h, int w) {
        map = new char[h][w];
        visit = new boolean[h][w];
        keys = new boolean[26];
        doors = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            doors.add(new ArrayList<>());
        }
        cnt = 0;
    }

    private boolean isWall(char val) {
        return val == '*';
    }

    private boolean isEmpty(char val) {
        return val == '.';
    }

    private boolean isKey(char val) {
        if (val > 'Z' && val <= 'z') {
            setKey(val);
            return true;
        }
        return false;
    }

    private boolean isDoor(char val, int x, int y) {
        if (val >= 'A' && val <= 'Z') {
            if (hasKey(val)) {
                return true;
            }
            doors.get(map[x][y] - 'A').add(new Point9328(x, y));
            return false;
        }
        return true;
    }

    private boolean isDoc(char val) {
        if (val == '$') {
            cnt++;
            return true;
        }
        return false;
    }

    private boolean isBoundary(int h, int w, int i, int j) {
        return i == 0 || j == 0 || i == h - 1 || j == w - 1;
    }

    private void setKey(char key) {
        keys[key - 'a'] = true;
    }

    private boolean hasKey(char door) {
        return keys[door - 'A'];
    }

    private void bfs(int h, int w) {
        while (!queue.isEmpty()) {
            Point9328 now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now.x + move[i][0];
                int y = now.y + move[i][1];
                // System.out.println(x + " " + y);
                if (x < 0 || y < 0 || x >= h || y >= w) {
                    continue;
                }
                if (isWall(map[x][y]) || visit[x][y]) {
                    continue;
                }
                if (isKey(map[x][y])) {
                    // 키없는 문으로 저장된 좌표중에서 존재하면 큐에 삽입
                    for (Point9328 door : doors.get(map[x][y] - 'a')) {
                        if(visit[door.x][door.y]) {
                            continue;
                        }
                        queue.add(door);
                        visit[door.x][door.y] = true;
                    }
                } else if (!isDoor(map[x][y], x, y)) {
                    // 문이 닫혀 있을때만  
                    continue;
                }
                isDoc(map[x][y]);
                visit[x][y] = true;
                queue.add(new Point9328(x, y));
            }
        }
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int testCase = Integer.parseInt(in.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            clearMap(h, w);
            for (int i = 0; i < h; i++) {
                String input = in.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                    if (!isBoundary(h, w, i, j)) {
                        continue;
                    }
                    if (isWall(map[i][j])) {
                        continue;
                    }
                    if (isEmpty(map[i][j]) || isDoc(map[i][j]) || isKey(map[i][j]) || isDoor(map[i][j], i, j)) {
                        queue.add(new Point9328(i, j));
                        visit[i][j] = true;
                    }
                }
            }
            char[] keyBundle = in.readLine().toCharArray();
            if (keyBundle[0] != '0') {
                for (char key : keyBundle) {
                    setKey(key);
                    for (Point9328 door : doors.get(key - 'a')) {
                        queue.add(door);
                        visit[door.x][door.y] = true;
                    }
                }
            }
            bfs(h, w);
            ans.append(cnt).append('\n');
            // printMap(h, w);
        }
        System.out.print(ans);
    }

    // private void printMap(int n, int m) {
    //     for(int i = 0; i < n; i++) {
    //         for(int j = 0; j < m; j++) {
    //             if(visit[i][j]) {
    //                 System.out.print(1 + " ");
    //             } else {
    //                 System.out.print(0 + " ");
    //             }
    //         }
    //         System.out.println();
    //     }
    // }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}