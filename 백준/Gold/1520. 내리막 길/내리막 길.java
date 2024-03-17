import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ1520Sol().run();
    }
}

class BOJ1520Sol {

    private int[][] map;
    private int[][] cache;
    private int n, m;
    private int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void clear() {
        map = new int[n][m];
        cache = new int[n][m];
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        clear();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cache[i][j] = -1;
            }
        }
    }

    private int getPathCnt(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }
        if (cache[x][y] != -1) {
            return cache[x][y];
        }
        cache[x][y] = 0; // visit
        for (int i = 0; i < 4; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            if (dx < 0 || dy < 0 || dx >= n || dy >= m || map[x][y] <= map[dx][dy]) {
                continue;
            }
            cache[x][y] += getPathCnt(dx, dy);
        }
        return cache[x][y];
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(getPathCnt(0, 0));
    }
}
