import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ13511Sol().run();
    }
}

class Node13511 {
    int no;
    long cost;

    Node13511(int no, long cost) {
        this.no = no;
        this.cost = cost;
    }

}

class BOJ13511Sol {

    private final int HIGH = 17;
    
    private List<List<Node13511>> tree;
    private boolean[] visit;
    private int[] depths;
    private long[] costs;
    private int[][] table;
    private int n;

    private void clear(int n) {
        this.n = n;
        tree = new ArrayList<>();
        visit = new boolean[n + 1];
        depths = new int[n + 1];
        costs = new long[n + 1];
        table = new int[HIGH][n + 1];
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
    }

    private void initTree(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        tree.get(a).add(new Node13511(b, cost));
        tree.get(b).add(new Node13511(a, cost));
    }

    private void dfs(int node, int depth, long sum) { // 1, 0, 0L
        visit[node] = true;
        depths[node] = depth;
        costs[node] = sum;
        for (Node13511 next : tree.get(node)) {
            if (visit[next.no]) {
                continue;
            }
            table[0][next.no] = node;
            dfs(next.no, depth + 1, sum + next.cost);
        }
    }

    private void setTable() {
        dfs(1, 0, 0L);
        for (int i = 1; i < HIGH; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = table[i - 1][table[i - 1][j]];
            }
        }
    }

    private int getLCA(int a, int b) {
        if (depths[a] < depths[b]) { // swap
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = HIGH - 1; i >= 0; i--) {
            if (depths[a] - depths[b] >= (1 << i)) {
                a = table[i][a];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = HIGH - 1; i >= 0; i--) {
            if (table[i][a] != table[i][b]) {
                a = table[i][a];
                b = table[i][b];
            }
        }
        return table[0][a];
    }

    private long getCost(int u, int v) {
        int lca = getLCA(u, v);
        return costs[u] + costs[v] - 2 * costs[lca];
    }

    private int getNode(int u, int v, int k) {

        int lca = getLCA(u, v);
        int gap = depths[u] - depths[lca] + 1;
        int size = 0;
        if (gap == k) {
            return lca;
        } else if (gap > k) {
            while ((size = depths[u] - depths[lca]) != gap - k) {
                for (int i = HIGH - 1; i >= 0; i--) {
                    if (size - (1 << i) >= gap - k) {
                        u = table[i][u];
                        break;
                    }
                }
            }
            return u;
        }
        while((size = depths[v] - depths[lca]) != k - gap) {
            for (int i = HIGH - 1; i >= 0; i--) {
                if (size - (1 << i) >= k - gap) {
                    v = table[i][v];
                    break;
                }
            }
        }
        return v;
    }

    private long calculateQuery(String query) {
        StringTokenizer st = new StringTokenizer(query);
        String order = st.nextToken();
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        if (order.equals("2")) {
            int k = Integer.parseInt(st.nextToken());
            return getNode(u, v, k);
        }
        return getCost(u, v);
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        clear(Integer.parseInt(in.readLine()));
        for (int i = 0; i < n - 1; i++) {
            initTree(in.readLine());
        }
        setTable();
        int m = Integer.parseInt(in.readLine());
        while(m-- > 0) {
            ans.append(calculateQuery(in.readLine())).append('\n');
        }
        System.out.print(ans);
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}