import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {/* run */}

    static class BOJ1338Sol {
        private static final char ROW = '-';
        private static final char COL = '|';

        char[][] room;
        boolean[][] visit;

        void clear(int n, int m) {
            room = new char[n][m];
            visit = new boolean[n][m];
        }

        int dfs(int n, int m) {
            int cnt = 0;
            Stack<Point> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visit[i][j]) {
                        continue;
                    }
                    cnt++;
                    stack.push(new Point(i, j));        
                    while (!stack.isEmpty()) {
                        Point now = stack.pop();
                        if (visit[now.x][now.y]) {
                            continue;
                        }
                        visit[now.x][now.y] = true;
                        if (room[now.x][now.y] == ROW && now.y != m - 1) {
                            if (room[now.x][now.y + 1] == ROW) {
                                stack.push(new Point(now.x, now.y + 1));
                            }
                        }else if (room[now.x][now.y] == COL && now.x != n - 1) {
                            if (room[now.x + 1][now.y] == COL) {
                                stack.push(new Point(now.x + 1, now.y));
                            }
                        }
                    }
                }
            }

            return cnt;
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            clear(n, m);

            for (int i = 0; i < n; i++) {
                room[i] = in.readLine().toCharArray();
            }

            System.out.print(dfs(n, m));
        }

    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static {
        try {
            new BOJ1338Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
