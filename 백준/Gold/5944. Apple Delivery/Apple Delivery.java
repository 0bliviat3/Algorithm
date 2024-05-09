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
    public static void main(String[] args) {/* run */}

    /**
     * a[] 집 a의 모든 최단경로
     * b[] 집 b의 모든 최단경로
     * min(a[start], b[start]) + a[b]
     */


    static class Node {
        int end;
        int dist;

        Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        int compare(Node node) {
            return this.dist - node.dist;
        }
    }

    static class BOJ5966Sol {

        private static final int INF = 2_000_000_001;
        private List<List<Node>> edges;

        void clear(int n) {
            edges = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
            }
        }

        void initEdge(String input) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Node(b, dist));
            edges.get(b).add(new Node(a, dist));
        }

        int addINF(int a, int b) {
            if ((long) a + (long) b > INF) {
                return INF;
            }
            return a + b;
        }

        int[] dijkstra(int n, int start) {
            AbstractQueue<Node> heap = new PriorityQueue<>(Node::compare);
            int[] dists = new int[n + 1];
            Arrays.fill(dists, INF);

            dists[start] = 0;
            heap.add(new Node(start, 0));

            while (!heap.isEmpty()) {
                Node node = heap.poll();
                for (Node next : edges.get(node.end)) {
                    if (dists[next.end] > addINF(dists[node.end], next.dist)) {
                        dists[next.end] = addINF(dists[node.end], next.dist);
                        heap.add(new Node(next.end, dists[next.end]));
                    }
                }
            }

            return dists;
        }

        void printAns(int a, int b, int start, int n) {
            int[] distA = dijkstra(n, a);
            int[] distB = dijkstra(n, b);

            System.out.print((long) distA[b] + (long) Math.min(distA[start], distB[start]));
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int c = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            clear(n);

            while (c-- > 0) {
                initEdge(in.readLine());
            }

            printAns(a, b, start, n);
        }
    }

    static {
        try {
            new BOJ5966Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}