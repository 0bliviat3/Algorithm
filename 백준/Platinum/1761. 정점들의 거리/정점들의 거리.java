import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ1761Sol().run();
    }
}

class Node1761 {
    int node;
    int dist;

    Node1761(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class BOJ1761Sol {

    private static final int NOT_VISIT = -1;
    
    private List<List<Node1761>> tree;
    private int[] depths;
    private int[] dists;
    private int[][] table;
    private int n, h;

    private void setH() {
        h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
    }

    private void clear() {
        setH();
        tree = new ArrayList<>();
        depths = new int[n + 1];
        dists = new int[n + 1];
        table = new int[h][n + 1];
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        Arrays.fill(depths, NOT_VISIT);
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());
        tree.get(start).add(new Node1761(end, dist));
        tree.get(end).add(new Node1761(start, dist));
    }

    private void dfs(int node, int depth) {
        depths[node] = depth;
        for(Node1761 next : tree.get(node)) {
            if(depths[next.node] > NOT_VISIT) {
                continue;
            }
            table[0][next.node] = node;
            dists[next.node] = dists[node] + next.dist;
            dfs(next.node, depth + 1);
        }
    }

    private void setTable() {
        dfs(1, 0);
        for(int k = 1; k < h; k++) {
            for(int i = 1; i <= n; i++) {
                table[k][i] = table[k - 1][table[k - 1][i]];
            }
        }
    }

    private int LCA(int a, int b) {
        int dist = dists[a] + dists[b];
        if(depths[a] < depths[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i = h - 1; i >= 0; i--) {
            if(depths[a] - depths[b] >= (1 << i)) {
                a = table[i][a];
            }
        }
        if(a == b) {
            return dist - (dists[a] << 1);
        }
        for(int i = h - 1; i >= 0; i--) {
            if(table[i][a] != table[i][b]) {
                a = table[i][a];
                b = table[i][b];
            }
        }
        return dist - (dists[table[0][a]] << 1);
    }

    private int setQuery(String query) {
        StringTokenizer st = new StringTokenizer(query);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        return LCA(a, b);
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        n = Integer.parseInt(in.readLine());
        clear();
        for(int i = 1; i < n; i++) {
            init(in.readLine());
        }
        setTable();
        int m = Integer.parseInt(in.readLine());
        while(m-- > 0) {
            ans.append(setQuery(in.readLine())).append('\n');
        }
        System.out.print(ans);
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
