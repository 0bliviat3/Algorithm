import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ21924Sol(new UnionFind21942()).run();
    }
}

class Edge21924 implements Comparable<Edge21924> {
    int start;
    int end;
    int cost;

    Edge21924(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge21924 o) {
        return this.cost - o.cost;
    }
}

class BOJ21924Sol {

    private final UnionFind21942 unionFind;
    private List<Edge21924> edges;

    BOJ21924Sol(final UnionFind21942 unionFind) {
        this.unionFind = unionFind;
    }

    private void clear(int n) {
        unionFind.clear(n);
        edges = new ArrayList<>();
    }

    private int init(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        edges.add(new Edge21924(start, end, cost));
        return cost;
    }

    private long krukcal(int n) {
        long res = 0;
        int cnt = 0;
        Collections.sort(edges);
        for (Edge21924 edge : edges) {
            if (cnt == n - 1) {
                return res;
            }
            if (unionFind.union(edge.start, edge.end)) {
                res += edge.cost;
                cnt++;
            }
        }
        return res;
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long ans = 0;
        clear(n);
        while (m-- > 0) {
            ans += init(in.readLine());
        }
        ans -= krukcal(n);
        if (!unionFind.isCycle(n)) {
            System.out.print(-1);
            return;
        }
        System.out.print(ans);
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}

class UnionFind21942 {
    private List<Integer> parent;

    void clear(int n) {
        parent = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            parent.add(i);
        }
    }

    private int find(int x) {
        if (parent.get(x) == x) {
            return x;
        }
        parent.set(x, find(parent.get(x)));
        return parent.get(x);
    }

    boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent.set(b, a);
            return true;
        }
        return false;
    }

    boolean isCycle(int n) {
        int temp = find(parent.get(1));
        for (int i = 2; i <= n; i++) {
            if (temp != find(parent.get(i))) {
                return false;
            }
        }
        return true;
    }
}
