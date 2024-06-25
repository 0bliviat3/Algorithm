import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {/* run */}

    static class BOJ11123Sol {
        static final char SHEEP = '#';
        static final char GLASS = '.';

        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        char[][] map;
        boolean[][] visit;

        void clear(int n, int m) {
            map = new char[n][m];
            visit = new boolean[n][m];
        }

        void initLine(String input, int row) {
            map[row] = input.toCharArray();
        }

        void dfs(int x, int y, int n, int m) {
            if (visit[x][y]) {
                return;
            }
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int dx = x + move[i][0];
                int dy = y + move[i][1];

                if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                    continue;
                }

                if (map[dx][dy] == SHEEP) {
                    dfs(dx, dy, n, m);
                }
            }
        }

        int countSheep(int n, int m) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == GLASS) {
                        continue;
                    }
                    if (visit[i][j]) {
                        continue;
                    }
                    cnt++;
                    dfs(i, j, n, m);
                }
            }
            return cnt;
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder ans = new StringBuilder();
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                clear(n, m);
                for (int i = 0; i < n; i++) {
                    initLine(in.readLine(), i);
                }
                ans.append(countSheep(n, m)).append('\n');
            }

            System.out.print(ans);
        }
    }

    static {
        try {
            new BOJ11123Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
