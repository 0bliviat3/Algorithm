import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {/* run */}

    static class Point {
        int x;
        int y;
        int val;
        
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        int compare(Point p) {
            return this.val - p.val;
        }
    }

    static class BOJ11909Sol {
        int[][] map;
        int[][] move = {{0, 1}, {1, 0}};
        final int INF = 987654321;

        void clear(int n) {
            map = new int[n + 1][n + 1];
        }

        int init() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            clear(n);
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            return n;
        }

        int dijkstra(int n) { //TODO: param init()
            boolean[][][] visit = new boolean[n + 1][n + 1][2];
            AbstractQueue<Point> heap = new PriorityQueue<>(Point::compare);
            heap.add(new Point(1, 1, 0));
            visit[1][1][0] = true;

            while (!heap.isEmpty()) {
                Point now = heap.poll(); //전진하는 순간

                if (now.x == n && now.y == n) {
                    return now.val;
                }               
                for (int i = 0; i < 2; i++) {
                    int x = now.x + move[i][0];
                    int y = now.y + move[i][1];

                    if (x > n || y > n) {
                        continue;
                    }
                    if (visit[x][y][i]) {
                        continue;
                    }
                    visit[x][y][i] = true;
                    if (map[now.x][now.y] > map[x][y]) {
                        heap.add(new Point(x, y, now.val));
                        continue;
                    }
                    heap.add(
                        new Point(x, y, now.val + map[x][y] - map[now.x][now.y] + 1));
                }
            }
            return INF;
        }

        void solve() {
            try {
                System.out.print(dijkstra(init()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static {
        new BOJ11909Sol().solve();
    }
}
