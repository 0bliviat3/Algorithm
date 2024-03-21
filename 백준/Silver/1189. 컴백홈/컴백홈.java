import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        new BOJ1189Sol().run();
    }

    static class BOJ1189Sol {

        private static final char WALL = 'T';
        boolean[][] map, visit;
        int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int r, c, k;

        void clear() {
            map = new boolean[r][c];
            visit = new boolean[r][c];
        }

        void init(String info) {
            StringTokenizer st = new StringTokenizer(info);
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
        }

        void init() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            init(in.readLine());
            clear();
            for (int i = 0; i < r; i++) {
                String input = in.readLine();
                for (int j = 0; j < c; j++) {
                    if (input.charAt(j) == WALL) {
                        map[i][j] = true;
                    }
                }
            }
        }

        void dfs(int x, int y, int cnt, AtomicInteger ans) {
            if (cnt == k) {
                if (x == 0 && y == c - 1) {
                    ans.incrementAndGet();
                }
                return;
            }
            for (int i = 0; i < 4; i++) {
                int dx = x + move[i][0];
                int dy = y + move[i][1];

                if (dx < 0 || dy < 0 || dx >= r || dy >= c) {
                    continue;
                }
                if (map[dx][dy] || visit[dx][dy]) {
                    continue;
                }
                visit[dx][dy] = true;
                dfs(dx, dy, cnt + 1, ans);
                visit[dx][dy] = false;
            }
        }

        void run() {
            try {
                init();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AtomicInteger ans = new AtomicInteger();
            visit[r - 1][0] = true;
            dfs(r - 1, 0, 1, ans);
            System.out.print(ans.get());
        }

        
        
    }
}
