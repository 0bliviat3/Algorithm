import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ8012Sol().run();
    }
}

class BOJ8012Sol {
    private static final int NOT_VISIT = -1;
    private int n, h, start, end;
    private int[] depths;
    private int[] dists;
    private int[][] table;
    private List<List<Integer>> edges;

    private void setH() {
        h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
    }

    private void clear() {
        setH();
        depths = new int[n + 1];
        dists = new int[n + 1];
        table = new int[h][n + 1];
        edges = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
            depths[i] = NOT_VISIT;
        }
    }

    private void initEdge(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        edges.get(a).add(b);
        edges.get(b).add(a);
    }

    private void dfs(int city, int depth) {
        depths[city] = depth;
        for(int i : edges.get(city)) {
            if(depths[i] > NOT_VISIT) {
                continue;
            }
            table[0][i] = city;
            dists[i] = dists[city] + 1;
            dfs(i, depth + 1);
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

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int time = 0;
        n = Integer.parseInt(in.readLine());
        clear();
        for(int i = 1; i < n; i++) {
            initEdge(in.readLine());
        }
        int m = Integer.parseInt(in.readLine());
        setTable();
        start = 1;
        while(m-- > 0) {
            end = Integer.parseInt(in.readLine());
            time += LCA(start, end);
            start = end;
        }
        System.out.print(time);
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
