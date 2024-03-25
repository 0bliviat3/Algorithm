import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {public static void main(String[] args) throws IOException {new BOJ1240Sol().run();}
static class Node1240 {int no;int cost;Node1240(int no, int cost) {this.no = no;this.cost = cost;}}
static class BOJ1240Sol {List<List<Node1240>> edges;boolean[] visit;
void clear(int n) {edges = new ArrayList<>();visit = new boolean[n + 1];
for (int i = 0; i <= n; i++) {edges.add(new ArrayList<>());}}
void run() throws IOException {BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
StringBuilder ans = new StringBuilder();StringTokenizer st = new StringTokenizer(in.readLine());
int n = Integer.parseInt(st.nextToken());int m = Integer.parseInt(st.nextToken());
clear(n);for (int i = 1; i < n; i++) {init(in.readLine());}
AtomicInteger cost = new AtomicInteger();
for (int i = 0; i < m; i++) {
                st = new StringTokenizer(in.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                cost.set(0);
                Arrays.fill(visit, false);
                dfs(start, end, 0, cost);
                ans.append(cost.get()).append('\n');
            }
            System.out.print(ans);
        }
        void init(String input) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.get(a).add(new Node1240(b, cost));
            edges.get(b).add(new Node1240(a, cost));
        }
        void dfs(int start, int end, int sum, AtomicInteger cost) {
            if (visit[start]) {
                return;
            }
            visit[start] = true;
            if (start == end) {
                cost.set(sum);
                return;
            }
            for (Node1240 node : edges.get(start)) {
                if (visit[node.no]) {
                    continue;
                }
                dfs(node.no, end, sum + node.cost, cost);
            }
        }
    }
}
