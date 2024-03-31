import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new BOJ14716Sol().run();
    }

    static class BOJ14716Sol {
        int n, m;
        boolean[][] map;
        boolean[][] visit;

        int[][] move = { 
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
            { 1, 1 },
            { -1, -1 },
            { 1, -1 },
            { -1, 1 } 
        };

        void clear() {
            map = new boolean[n][m];
            visit = new boolean[n][m];
        }

        void init() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            clear();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = st.nextToken().equals("1");
                }
            }
        }

        int find() {
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] && !visit[i][j]) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            return cnt;
        }

        void dfs(int x, int y) {
            visit[x][y] = true;
            for (int i = 0; i < 8; i++) {
                int dx = x + move[i][0];
                int dy = y + move[i][1];

                if (dx < 0 || dy < 0 || dx >= n || dy >= m || visit[dx][dy] || !map[dx][dy]) {
                    continue;
                }
                dfs(dx, dy);
            }
        }

        void run() {
            try {
                init();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print(find());
        }

    }

}
