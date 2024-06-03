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
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        int compare(Node n) {
            return this.cost - n.cost;
        }
    }

    static class BOJ9140Sol {
        List<List<Node>> edges;
        private static final int INF = 987654321;
        private static final String END = "0 0 0 0";
        
        void clear(int n) {
            edges = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
            }
        }

        void init(String input) {
            StringTokenizer st = new StringTokenizer(input);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(start).add(new Node(end, cost));
            edges.get(end).add(new Node(start, cost));
        }

        int dijkstra(int n, int start, int complate) {
            AbstractQueue<Node> heap = new PriorityQueue<>(Node::compare);
            int[] costs = new int[n + 1];
            Arrays.fill(costs, INF);
            costs[start] = 0;
            heap.add(new Node(start, 0));


            while (!heap.isEmpty()) {
                Node node = heap.poll();

                for (Node next : edges.get(node.end)) {
                    if (costs[next.end] > costs[node.end] + next.cost) {
                        costs[next.end] = costs[node.end] + next.cost;
                        heap.add(new Node(next.end, costs[next.end]));
                    }
                }
            }

            return costs[complate];
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder ans = new StringBuilder();

            String input = null;
            while (!(input = in.readLine()).equals(END)) {
                StringTokenizer st = new StringTokenizer(input);
    
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int complate = Integer.parseInt(st.nextToken());
    
                clear(n);
    
                while (m-- > 0) {
                    init(in.readLine());
                }
                ans.append(dijkstra(n, start, complate)).append('\n');
            }

            System.out.print(ans);
        }

    }

    static {
        try {
            new BOJ9140Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
