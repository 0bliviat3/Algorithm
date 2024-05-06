import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new BOJ12834Sol().solve();
    }

    static class Point {
        int end;
        int dist;

        Point(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        int compare(Point p) {
            return this.dist - p.dist;
        }
    }

    static class BOJ12834Sol {

        static final int INF = 1234567890;
        List<List<Point>> edges;

        void clear(int n) {
            edges = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
            }
        }

        int[] dijkstra(int n, int start) { //TODO: a, b에서 한번씩만으로 거리 계산 가능.
            int[] dists = new int[n + 1];
            AbstractQueue<Point> heap = new PriorityQueue<>(Point::compare);

            Arrays.fill(dists, INF);

            dists[start] = 0;
            heap.add(new Point(start, 0));

            while (!heap.isEmpty()) {
                Point node = heap.poll();

                for (Point next : edges.get(node.end)) {
                    if (dists[next.end] > next.dist + node.dist) {
                        dists[next.end] = next.dist + node.dist;
                        heap.add(new Point(next.end, dists[next.end]));
                    }
                }
            }

            return dists;
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   
            List<Integer> homes = new ArrayList<>();

            /* init start */
            StringTokenizer st = new StringTokenizer(in.readLine());
            st.nextToken();
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());       
            st = new StringTokenizer(in.readLine());
            while (st.hasMoreTokens()) {
                homes.add(Integer.parseInt(st.nextToken()));
            }
            clear(v);
            while (e-- > 0) {
                initEdges(in.readLine());
            }
            /* init end */

            /* get dists */
            int[] distsByA = dijkstra(v, a);
            int[] distsByB = dijkstra(v, b);

            /* calculate sum */
            int ans = 0;
            for (int person : homes) {
                ans += (distsByA[person] == INF) ? -1 : distsByA[person];
                ans += (distsByB[person] == INF) ? -1 : distsByB[person];
            }

            /* print answer */
            System.out.print(ans);
        }

        void initEdges(String input) {
            StringTokenizer st = new StringTokenizer(input);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
    
            edges.get(start).add(new Point(end, dist));
            edges.get(end).add(new Point(start, dist));
        }
    }

}
