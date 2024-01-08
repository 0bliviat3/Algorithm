import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ1774Sol(new UnionFind()).run();
    }
}

class SpaceGod {
    double x;
    double y;

    SpaceGod(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getDist(SpaceGod otherGod) {
        return Math.sqrt(
            Math.pow(this.x - otherGod.x, 2) 
            + Math.pow(this.y - otherGod.y, 2));
    }
}

class Edge1774 implements Comparable<Edge1774> {
    int godA;
    int godB;
    double dist;

    Edge1774(int godA, int godB, double dist) {
        this.godA = godA;
        this.godB = godB;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge1774 o) {
        if(this.dist > o.dist) {
            return 1;
        }else if(this.dist < o.dist) {
            return -1;
        }
        return 0;
    }
}

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

class BOJ1774Sol {

    private final UnionFind unionFind;
    private List<SpaceGod> godList;
    private List<Edge1774> edges;

    BOJ1774Sol(final UnionFind unionFind) {
        this.unionFind = unionFind;
        godList = new ArrayList<>();
        edges = new ArrayList<>();
        godList.add(null);
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        unionFind.clear(n);

        for(int i = 0; i < n; i++) {
            init(in.readLine());
        }

        for(int i = 0; i < m; i++) {
            if(union(in.readLine())) {
                cnt++;
            }
        }

        init(n);
        System.out.printf("%.2f", kruskal(n - m + cnt));
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());

        godList.add(new SpaceGod(x, y));
    }

    private boolean union(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        return unionFind.union(a, b);
    }

    private void init(int n) {
        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                edges.add(new Edge1774(i, j,
                 godList.get(i)
                 .getDist(godList.get(j))));
            }
        }
    }

    private double kruskal(int n) {
        double sum = 0d;
        int cnt = 0;
        Collections.sort(edges);

        for(Edge1774 edge : edges) {
            if(cnt == n - 1) {
                return sum;
            }
            if(unionFind.union(edge.godA, edge.godB)) {
                sum += edge.dist;
                cnt++;
            }
        }
        return sum;
    }
    
}
