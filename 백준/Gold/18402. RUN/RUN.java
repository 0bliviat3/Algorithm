import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {/* run */}

    static class Node {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        int compare(Node n) {
            return this.cost - n.cost;
        }
    }

    static class BOJ18402Sol {
        List<List<Node>> edges;
        int[] costs;
        private static final int INF = 987654321;

        void clear(int n) {
            edges = new ArrayList<>();
            costs = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
                costs[i] = INF;
            }
        }

        void initEdge(String input) {
            StringTokenizer st = new StringTokenizer(input);
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(end).add(new Node(start, cost));
        }

        void dijkstra(int n, int e) {
            AbstractQueue<Node> heap = new PriorityQueue<>(Node::compare);
            heap.add(new Node(e, 0));
            costs[e] = 0;

            while (!heap.isEmpty()) {
                Node node = heap.poll();

                for (Node next : edges.get(node.end)) {
                    if (costs[next.end] > costs[node.end] + next.cost) {
                        costs[next.end] = costs[node.end] + next.cost;
                        heap.add(new Node(next.end, costs[next.end]));
                    }
                }
            }
        }

        int countInmate(int time) {
            int cnt = 0;
            for (int inmate : costs) {
                if (inmate > time) {
                    continue;
                }
                cnt++;
            }
            return cnt;
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            
            // String firstInput = in.readLine();
            int n = Integer.parseInt(in.readLine().trim());
            int e = Integer.parseInt(in.readLine().trim());
            int t = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());

            clear(n);

            while (m-- > 0) {
                initEdge(in.readLine());
            }

            dijkstra(n, e);
            System.out.print(countInmate(t));
        }

    }
    
    static {
        try {
            new BOJ18402Sol().solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
