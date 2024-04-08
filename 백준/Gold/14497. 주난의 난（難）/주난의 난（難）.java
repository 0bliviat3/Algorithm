import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new BOJ14497Sol().solve();
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

        int compare(Point point) {
            return this.dist - point.dist;
        }

    }

    static class BOJ14497Sol {
        int n, m;
        int[][] map;
        int[][] jumps;
        final char TARGET = '#';
        final char START = '*';
        int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        void clear() {
            map = new int[n][m];
            jumps = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(jumps[i], Integer.MAX_VALUE);
            }
        }

        void dijkstra(Point start) {
            AbstractQueue<Point> heap = new PriorityQueue<>(Point::compare);
            heap.add(start);
            jumps[start.x][start.y] = 0;

            while(!heap.isEmpty()) {
                Point now = heap.poll();

                for (int i = 0; i < 4; i++) {
                    int x = now.x + move[i][0];
                    int y = now.y + move[i][1];

                    if (x < 0 || y < 0 || x >= n || y >= m) {
                        continue;
                    }
                    if (jumps[x][y] > jumps[now.x][now.y] + map[x][y]) {
                        jumps[x][y] = jumps[now.x][now.y] + map[x][y];
                        heap.add(new Point(x, y, jumps[x][y]));
                    }
                }
            }
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            clear();

            st = new StringTokenizer(in.readLine());

            Point start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
            Point end = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 1);
            
            for (int i = 0; i < n; i++) {
                String input = in.readLine();
                for (int j = 0; j < m; j++) {
                    char val = input.charAt(j);
                    if (val == START) {
                        continue;
                    } else if (val == TARGET) {
                        map[i][j] = 1;
                        continue;
                    }
                    map[i][j] = val - '0';
                }
            }

            dijkstra(start);

            System.out.print(jumps[end.x][end.y]);

        }
    }
}
