import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {/* run */}

    static {
        try {
            new BOJ10159Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class BOJ10159Sol {
        int[][] map;
        static final int INF = 123456789;
        
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

        void initMap(String input) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
        }

        void floyd(int n) {
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }
        }

        void printINF(int n) {
            StringBuilder ans = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                int cnt = 0;
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] == INF && map[j][i] == INF) {
                        cnt++;
                    }
                }
                ans.append(cnt).append('\n');
            }
            System.out.print(ans);
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());

            clear(n);

            while (m-- > 0) {
                initMap(in.readLine());
            }

            floyd(n);

            printINF(n);
        }

    }
}
