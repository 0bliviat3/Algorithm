import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ6497Sol(new UnionFind()).run();
    }
}

class Edge6497 implements Comparable<Edge6497> {
    int roadA;
    int roadB;
    int cost;

    Edge6497(int roadA, int roadB, int cost) {
        this.roadA = roadA;
        this.roadB = roadB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge6497 o) {
        return this.cost - o.cost;
    }
}

class BOJ6497Sol {

    private static final String EMPTY = " ";
    private static final char LINE = '\n';
    private static final String END = "0 0";

    private List<Edge6497> edges;
    private final UnionFind unionFind;

    BOJ6497Sol(final UnionFind unionFind) {
        this.unionFind = unionFind;       
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String input = null;

        while(!(input = in.readLine()).equals(END)) {
            StringTokenizer st = new StringTokenizer(input, EMPTY);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int sum = 0;
            unionFind.clear(n);
            edges = new ArrayList<>();
            while(m-- > 0) {
                sum += init(in.readLine());
            }
            ans.append(sum - kruskal(n)).append(LINE);
        }
        System.out.print(ans);
        
    }

    private int init(String input) {
        StringTokenizer st = new StringTokenizer(input, EMPTY);
        int roadA = Integer.parseInt(st.nextToken());
        int roadB = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        edges.add(new Edge6497(roadA, roadB, cost));
        return cost;
    }

    private int kruskal(int n) {
        int cnt = 0;
        int sum = 0;
        Collections.sort(edges);
        for(Edge6497 edge : edges) {
            if(cnt == n - 1) {
                return sum;
            }
            if(unionFind.union(edge.roadA, edge.roadB)) {
                cnt++;
                sum += edge.cost;
            }
        }
        return sum;
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/* UNION-FIND */
class UnionFind {
    
    private List<Integer> parent;

    void clear(int n) {
        parent = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            parent.add(i);
        }
    }

    private int getParent(int x) {
        if(parent.get(x) == x) {
            return x;
        }
        parent.set(x, getParent(parent.get(x)));
        return parent.get(x);
    }

    boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a != b) {
            parent.set(b, a);
            return true;
        }
        return false;
    }
}