import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new BOJ16929Sol().run();
    }

    static class BOJ16929Sol {

        char[][] map;
        int n, m;

        int[][] visit;
        int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        void clear() {
            map = new char[n][m];
            visit = new int[n][m];
        }

        void init() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            clear();

            for (int i = 0; i < n; i++) {
                map[i] = in.readLine().toCharArray();
            }
        }

        boolean find() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visit[i][j] != 0) {
                        continue;
                    }
                    if (dfs(i, j, 1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean dfs(int x, int y, int cnt) {
            visit[x][y] = cnt;

            for (int i = 0; i < 4; i++) {
                int dx = x + move[i][0];
                int dy = y + move[i][1];

                if (dx < 0 || dy < 0 || dx >= n || dy >= m || map[x][y] != map[dx][dy]) {
                    continue;
                }
                if (visit[dx][dy] != 0) { //이미 방문한 경우
                    if (cnt - visit[dx][dy] >= 3) { //depth가 3이상이라면 사이클
                        return true;
                    }
                    continue;
                }
                if (dfs(dx, dy, cnt + 1)) { // 사이클이면 true
                    return true;
                }
            }
            return false;
        }

        void run() {
            try {
                init();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (find()) {
                System.out.print("Yes");
                return;
            }
            System.out.print("No");
        }
    }
}
