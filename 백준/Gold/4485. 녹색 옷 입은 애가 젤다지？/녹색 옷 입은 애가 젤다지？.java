import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new BOJ4485Sol().solve();
    }

    static class Point {
        int x;
        int y;
        int cost;

        Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        int compare(Point p) {
            return this.cost - p.cost;
        }
    }

    static class BOJ4485Sol {

        int[][] map;
        int[][] costs;
        int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        void clear(int n) {
            map = new int[n][n];
            costs = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(costs[i], Integer.MAX_VALUE);
            }
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder ans = new StringBuilder();
            int n = 0;
            int problem = 0;
            String ansFormat = "Problem %d: %d\n";

            while((n = Integer.parseInt(in.readLine())) != 0) {
                clear(n);
                for (int i = 0; i < n; i++) {
                    StringTokenizer st = new StringTokenizer(in.readLine());
                    for (int j = 0; j < n; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                ans.append(String.format(ansFormat, ++problem, dijkstra(n)));
            }
            System.out.print(ans);
        }

        private int dijkstra(int n) {

            AbstractQueue<Point> heap = new PriorityQueue<>(Point::compare);
            costs[0][0] = map[0][0];
            heap.add(new Point(0, 0, map[0][0]));

            while(!heap.isEmpty()) {
                Point now = heap.poll();
                
                for (int i = 0; i < 4; i++) {
                    int x = now.x + move[i][0];
                    int y = now.y + move[i][1];

                    if (x < 0 || y < 0 || x >= n || y >= n) {
                        continue;
                    }

                    if (costs[x][y] > costs[now.x][now.y] + map[x][y]) {
                        costs[x][y] = costs[now.x][now.y] + map[x][y];
                        heap.add(new Point(x, y, costs[x][y]));
                    }

                }
            }

            return costs[n - 1][n - 1];
        }

    }
}
