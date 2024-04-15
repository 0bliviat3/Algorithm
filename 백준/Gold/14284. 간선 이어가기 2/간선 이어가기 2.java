import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new BOJ14284Sol().solve();
    }

    static class Edge {
        int x;
        int dist;

        Edge(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }

        int compare(Edge edge) {
            return this.dist - edge.dist;
        }
    }

    static class BOJ14284Sol {

        List<List<Edge>> edges;
        int[] dists;

        void clear(int n) {
            edges = new ArrayList<>();
            dists = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
                dists[i] = Integer.MAX_VALUE;
            }
        }

        void init(String input) {
            StringTokenizer st = new StringTokenizer(input);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            edges.get(start).add(new Edge(end, dist));
            edges.get(end).add(new Edge(start, dist));
        }

        int addINF(int x, int y) {
            if (x == Integer.MAX_VALUE || y == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return x + y;
        }

        int dijkstra(String input) {

            StringTokenizer st = new StringTokenizer(input);

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            AbstractQueue<Edge> heap = new PriorityQueue<>(Edge::compare);
            heap.add(new Edge(start, 0));
            dists[start] = 0;

            while(!heap.isEmpty()) {
                Edge edge = heap.poll();

                for (Edge next : edges.get(edge.x)) {
                    if (dists[next.x] > addINF(dists[edge.x], next.dist)) {
                        dists[next.x] = addINF(dists[edge.x], next.dist);
                        heap.add(new Edge(next.x, dists[next.x]));
                    }
                }
            }

            return dists[target];
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            clear(n);

            while(m-- > 0) {
                init(in.readLine());
            }

            System.out.print(dijkstra(in.readLine()));
        }
    }


}
