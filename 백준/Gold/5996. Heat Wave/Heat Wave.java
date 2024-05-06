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

    static class Node {
        int end;
        int dist;

        Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        int compare(Node n) {
            return this.dist - n.dist;
        }
    }

    static class BOJ5996Sol {
        List<List<Node>> edges;
        static final int INF = 987654321;

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

        int dijkstra(int n, int start, int end) {
            AbstractQueue<Node> heap = new PriorityQueue<>(Node::compare);
            int[] dists = new int[n + 1];
            Arrays.fill(dists, INF);

            dists[start] = 0;
            heap.add(new Node(start, 0));

            while (!heap.isEmpty()) {
                Node node = heap.poll();

                for (Node next : edges.get(node.end)) {
                    if (dists[next.end] > dists[node.end] + next.dist) {
                        dists[next.end] = dists[node.end] + next.dist;
                        heap.add(new Node(next.end, dists[next.end]));
                    }
                }
            }

            return dists[end];
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            clear(n);

            while (m-- > 0) {
                initEdge(in.readLine());
            }

            System.out.print(dijkstra(n, start, end));
        }
    }

    static {
        try {
            new BOJ5996Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
