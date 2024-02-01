import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ11438sol().run();
    }
}

class BOJ11438sol {

    private static final int NOT_VISIT = -1;
    private List<List<Integer>> tree;
    private int[][] table;
    private int[] depths;
    private int n, h;

    private int getLog() {
        return (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
    }

    private void clear() {
        tree = new ArrayList<>();
        h = getLog();
        table = new int[h][n + 1];
        depths = new int[n + 1];
        Arrays.fill(depths, NOT_VISIT);
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        tree.get(a).add(b);
        tree.get(b).add(a);
    }

    private void dfs(int node, int depth) {
        depths[node] = depth;
        for(int next : tree.get(node)) {
            if(depths[next] > NOT_VISIT) {
                continue;
            }
            table[0][next] = node;
            dfs(next, depth + 1);
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
        if(depths[a] < depths[b]) { // a depth > b depth
            int temp = b;
            b = a;
            a = temp;
        }
        for(int i = h - 1; i >= 0; i--) {
            if(depths[a] - depths[b] >= (1 << i)) {
                a = table[i][a];
            }
        }
        if(a == b) {
            return a;
        }
        for(int i = h - 1; i >= 0; i--) {
            if(table[i][a] != table[i][b]) {
                a = table[i][a];
                b = table[i][b];
            }
        }
        return table[0][a];
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        n = Integer.parseInt(in.readLine());
        clear();
        for(int i = 1; i < n; i++) {
            init(in.readLine());
        }
        int m = Integer.parseInt(in.readLine());
        setTable();
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ans.append(LCA(a, b)).append('\n');
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
