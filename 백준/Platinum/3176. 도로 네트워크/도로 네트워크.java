import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ3176Sol().run();
    }
}

class Node3176 {
    int node;
    int dist;

    Node3176(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class BOJ3176Sol {

    private static final int NOT_VISIT = -1;
    private List<List<Node3176>> tree;
    private int[] depths;
    private int[][] minTable;
    private int[][] maxTable;
    private int[][] table;
    private int n, h;

    private void setH() {
        h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
    }

    private void clear() {
        setH();
        tree = new ArrayList<>();
        depths = new int[n + 1];
        table = new int[h][n + 1];
        minTable = new int[h][n + 1];
        maxTable = new int[h][n + 1];
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
            depths[i] = NOT_VISIT;
        }

        for (int i = 0; i < h; i++) {
            Arrays.fill(minTable[i], Integer.MAX_VALUE);
            Arrays.fill(maxTable[i], Integer.MIN_VALUE);
        }
    }

    private void initTree(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());
        tree.get(start).add(new Node3176(end, dist));
        tree.get(end).add(new Node3176(start, dist));
    }

    private void dfs(int node, int depth) {
        depths[node] = depth;
        for (Node3176 next : tree.get(node)) {
            if (depths[next.node] > NOT_VISIT) {
                continue;
            }
            table[0][next.node] = node;
            minTable[0][next.node] = next.dist;
            maxTable[0][next.node] = next.dist;
            dfs(next.node, depth + 1);
        }
    }

    private void setTable() {
        dfs(1, 0);
        for (int k = 1; k < h; k++) {
            for (int i = 1; i <= n; i++) {

                minTable[k][i] = Math.min(
                    minTable[k - 1][i], minTable[k - 1][table[k - 1][i]]);
                maxTable[k][i] = Math.max(
                    maxTable[k - 1][i], maxTable[k - 1][table[k - 1][i]]);
                table[k][i] = table[k - 1][table[k - 1][i]];
            }
        }
    }

    private int[] calQuery(String query) {
        StringTokenizer st = new StringTokenizer(query);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        return LCA(a, b);
    }

    private int[] LCA(int a, int b) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (depths[a] < depths[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = h - 1; i >= 0; i--) {
            if (depths[a] - depths[b] >= (1 << i)) {
                min = Math.min(min, minTable[i][a]);
                max = Math.max(max, maxTable[i][a]);
                a = table[i][a];
            }
        }
        if (a == b) {
            return new int[] { min, max };
        }
        for (int i = h - 1; i >= 0; i--) {
            if (table[i][a] != table[i][b]) {
                min = Math.min(min, Math.min(minTable[i][a], minTable[i][b]));
                max = Math.max(max, Math.max(maxTable[i][a], maxTable[i][b]));
                a = table[i][a];
                b = table[i][b];
            }
        }

        min = Math.min(min, Math.min(minTable[0][a], minTable[0][b]));
        max = Math.max(max, Math.max(maxTable[0][a], maxTable[0][b]));

        return new int[] { min, max };
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        n = Integer.parseInt(in.readLine());
        clear();
        for(int i = 1; i < n; i++) {
            initTree(in.readLine());
        }
        setTable();
        int m = Integer.parseInt(in.readLine());
        while(m-- > 0) {
            int[] res = calQuery(in.readLine());
            ans.append(res[0]).append(' ').append(res[1]).append('\n');
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