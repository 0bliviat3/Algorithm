import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new BOJ23286Sol().solve();
    }

    static class BOJ23286Sol {
        int[][] map;
        static final int INF = 1234567890;

        void clear(int n) {
            map = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }
                    map[i][j] = INF;
                }
            }
        }

        void init(String edge) {
            StringTokenizer st = new StringTokenizer(edge);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());

            map[a][b] = high;
        }

        void floyd(int n) {
            for (int k = 1; k <= n; k++) { // 거쳐가는 정점.. 거쳐가는 정점중 더 높은 허들과 비교해야함.
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        map[i][j] = Math.min(map[i][j], Math.max(map[i][k], map[k][j]));
                    }
                }
            }
        }

        int calculateQuery(String query) {
            StringTokenizer st = new StringTokenizer(query);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (map[start][end] == INF) {
                return -1;
            }
            return map[start][end];
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder ans = new StringBuilder();

            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            clear(n);

            while (m-- > 0) {
                init(in.readLine());
            }

            floyd(n);

            while (t-- > 0) {
                ans.append(calculateQuery(in.readLine())).append('\n');
            }

            System.out.print(ans);
        }
    }
}
