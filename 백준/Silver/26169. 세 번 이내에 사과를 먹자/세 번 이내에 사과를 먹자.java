import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {/* run */}

    static class BOJ26169Sol {

        static final int N = 5;

        int[][] map;
        boolean[][] visit;
        int[][] move;
        int[] start;

        void clear() {
            map = new int[N][N];
            visit = new boolean[N][N];
            move = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            start = new int[2];
        }

        void init() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            clear();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visit[i][j] = map[i][j] == -1;
                }
            }

            initStart(in.readLine());
        }

        void initStart(String input) {
            StringTokenizer st = new StringTokenizer(input);
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
        }

        void dfs(int x, int y, int moveCnt, int appleCnt, AtomicBoolean flag) {
            if (visit[x][y]) {
                return;
            }
            if (moveCnt > 3) {
                return;
            }
            if (map[x][y] == -1) {
                return;
            }
            if (flag.get()) {
                return;
            }
            

            for (int i = 0; i < 4; i++) {
                int dx = move[i][0] + x;
                int dy = move[i][1] + y;

                if (dx < 0 || dy < 0 || dx >= N || dy >= N || visit[dx][dy] || map[dx][dy] == -1) {
                    continue;
                }

                visit[x][y] = true;
                moveCnt++;
                appleCnt += map[x][y];
                if (appleCnt > 1) {
                    flag.set(true);
                }
                dfs(dx, dy, moveCnt, appleCnt, flag);
                visit[x][y] = false;
                moveCnt--;
                appleCnt -= map[x][y];

            }
        }

        void solve() {
            try {
                init();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AtomicBoolean flag = new AtomicBoolean();
            dfs(start[0], start[1], 0, map[start[0]][start[1]], flag);

            if (flag.get()) {
                System.out.print(1);
                return;
            }
            System.out.print(0);
        }
    }

    static {
        new BOJ26169Sol().solve();
    }
}
