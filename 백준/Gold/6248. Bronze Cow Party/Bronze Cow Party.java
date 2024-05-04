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
    
    static {
        try {
            new BOJ6248().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {/* run */}

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

    static class BOJ6248 {
        
        /*
         * 최장 경로 * 2
         * 간선 정보 init시 최단거리로 갱신
         */

        int[][] map;
        List<List<Integer>> edges;

        static final int INF = 1234567890;

        void clear(int n) {
            map = new int[n + 1][n + 1];
            edges = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                Arrays.fill(map[i], INF);
                edges.add(new ArrayList<>());
            }
        }

        void initEdge(String input) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            edges.get(b).add(a);

            map[a][b] = map[b][a] = Math.min(map[a][b], dist);
        }

        int dijkstra(int start, int n) {
            AbstractQueue<Node> heap = new PriorityQueue<>(Node::compare);
            int[] dists = new int[n + 1];
            Arrays.fill(dists, INF);

            heap.add(new Node(start, 0));
            dists[start] = 0;

            while (!heap.isEmpty()) {
                Node now = heap.poll();

                for (int next : edges.get(now.end)) {
                    if (dists[next] > now.dist + map[now.end][next]) {
                        dists[next] = now.dist + map[now.end][next];
                        heap.add(new Node(next, dists[next]));
                    }
                }
            }

            int max = 0;
            for (int i = 1; i <= n; i++) {
                max = Math.max(max, dists[i]);
            }

            return max << 1;
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            clear(n);

            while (m-- > 0) {
                initEdge(in.readLine());
            }

            System.out.print(dijkstra(start, n));
        }   
    }
}