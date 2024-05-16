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
        int no;
        int time;

        Node(int no, int time) {
            this.no = no;
            this.time = time;
        }

        int compare(Node node) {
            return this.time - node.time;
        }
    }

    static class BOJ6054Sol {
        List<List<Integer>> edges;
        int[] times;
        static final int INF = 987654321;

        void clear(int n) {
            edges = new ArrayList<>();
            times = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
            }
        }

        void initEdge(int i, String input) {
            StringTokenizer st = new StringTokenizer(input);
            int time = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            times[i] = time;

            while (m-- > 0) {
                int next = Integer.parseInt(st.nextToken());
                edges.get(i).add(next);
            }
        }

        int getMax(int [] arr) {
            int max = 0;
            for (int i : arr) {
                if (i == INF) {
                    continue;
                }
                max = Math.max(i, max);
            }
            return max;
        }

        int dijkstra(int n) {
            int[] times = new int[n + 1];
            AbstractQueue<Node> heap = new PriorityQueue<>(Node::compare);

            Arrays.fill(times, INF);
            times[1] = this.times[1];
            heap.add(new Node(1, times[1]));

            while (!heap.isEmpty()) {
                Node node = heap.poll();

                for (int next : edges.get(node.no)) {
                    if (times[next] > times[node.no] + this.times[next]) {
                        times[next] = times[node.no] + this.times[next];
                        heap.add(new Node(next, times[next]));
                    }
                }
            }

            return getMax(times);
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            clear(n);
            for (int i = 1; i <= n; i++) {
                initEdge(i, in.readLine());
            }
            System.out.print(dijkstra(n));;
        }
    }

    static {
        try {
            new BOJ6054Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
