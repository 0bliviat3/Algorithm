import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new BOJ20046Sol().solve();
    }

    static class Point {
        int x;
        int y;
        int dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        int compare(Point p) {
            return this.dist - p.dist;
        }
    }

    static class BOJ20046Sol {
        int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int[][] map;
        int[][] dists;
        private static final int X = -1;
        private static final int INF = 1234567890;

        void clear(int n, int m) {
            map = new int[n][m];
            dists = new int[n][m];
        }

        int dijkstra(int n, int m) {
            AbstractQueue<Point> heap = new PriorityQueue<>(Point::compare);
            dists[0][0] = map[0][0];
            heap.add(new Point(0, 0, map[0][0]));

            while(!heap.isEmpty()) {
                Point point = heap.poll();

                for (int i = 0; i < 4; i++) {
                    int x = point.x + move[i][0];
                    int y = point.y + move[i][1];

                    if (x < 0 || y < 0 || x >= n || y >= m) {
                        continue;
                    }
                    if (map[x][y] == X) {
                        continue;
                    }
                    if (dists[x][y] > dists[point.x][point.y] + map[x][y]) {
                        dists[x][y] = dists[point.x][point.y] + map[x][y];
                        heap.add(new Point(x, y, dists[x][y]));
                    }
                }
            }
            
            if (dists[n - 1][m - 1] == INF) {
                return X;
            }
            return dists[n - 1][m - 1];
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            clear(n, m);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dists[i][j] = INF;
                }
            }
            if (map[0][0] == X) {
                System.out.print(-1);
                return;
            }
            System.out.print(dijkstra(n, m));
        }


    }

}
