import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {/* run */}

    static class BOJ16173Sol {

        int[][] map;
        boolean[][] visit;

        void clear(int n) {
            map = new int[n][n];
            visit = new boolean[n][n];
        }

        void dfs(int x, int y, int n) {
            if (visit[x][y]) {
                return;
            }
            visit[x][y] = true;
            if (map[x][y] == -1) {
                return;
            }
            if (x + map[x][y] < n) {
                dfs(x + map[x][y], y, n);
            }
            if (y + map[x][y] < n) {
                dfs(x, y + map[x][y], n);
            }
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());

            clear(n);

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0, n);

            if (visit[n - 1][n - 1]) {
                System.out.print("HaruHaru");
                return;
            }
            System.out.print("Hing");
        }

    }

    static {
        try {
            new BOJ16173Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
