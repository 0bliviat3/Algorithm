import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // 문제이해 잘못함 경로를 적어줘야함
        new BOJ1719Sol().solve();
    }

    static class BOJ1719Sol {
        int[][] map;
        int[][] road;
        
        void clear(int n) {
            map = new int[n + 1][n + 1];
            road = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }
                    map[i][j] = Integer.MAX_VALUE;
                    road[i][j] = j;
                }
            }
        }

        int getMin(int x, int a, int b) {
            if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE) {
                return x;
            }
            return Math.min(x, a + b);
        }

        void floyd(int n) {
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE) {
                            continue;
                        }
                        if (map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                            road[i][j] = road[i][k];
                        }
                    }
                }
            }
        }

        void printAns(int n) {
            StringBuilder ans = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        ans.append('-').append(' ');
                        continue;
                    }
                    ans.append(road[i][j]).append(' ');
                }
                ans.append('\n');
            }
            System.out.print(ans);
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            clear(n);
            while (m-- > 0) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                map[a][b] = map[b][a] = cost;
            }

            floyd(n);
            printAns(n);
        }
    }
}
