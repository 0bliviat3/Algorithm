import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ16398Sol(new UnionFind()).run();
    }
}

class PlanetEdge implements Comparable<PlanetEdge> {
    int planetA;
    int planetB;
    int managementCost;

    PlanetEdge(int planetA, int planetB, int managementCost) {
        this.planetA = planetA;
        this.planetB = planetB;
        this.managementCost = managementCost;
    }

    @Override
    public int compareTo(PlanetEdge o) {
        return this.managementCost - o.managementCost;
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

    private int find(int x) {
        if(parent.get(x) == x) {
            return x;
        }
        parent.set(x, find(parent.get(x)));
        return parent.get(x);
    }

    boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent.set(b, a);
            return true;
        }
        return false;
    }
}

class BOJ16398Sol {
    
    private List<PlanetEdge> edges;
    private final UnionFind unionFind;

    BOJ16398Sol(final UnionFind unionFind) {
        this.unionFind = unionFind;
    }

    private void clear(int n) {
        edges = new ArrayList<>();
        unionFind.clear(n);
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        clear(n);
        for(int i = 0; i < n; i++) {
            init(n, in.readLine(), i);
        }
        System.out.println(krukcal(n));
    }

    private void init(int n, String input, int i) {
        StringTokenizer st = new StringTokenizer(input, " ");
        for(int j = 0; j < n; j++) {
            int cost = Integer.parseInt(st.nextToken());
            if(i < j) {
                edges.add(new PlanetEdge(i, j, cost));
            }
        }
    }

    private long krukcal(int n) {
        long res = 0;
        int cnt = 0;
        Collections.sort(edges);
        for(PlanetEdge edge : edges) {
            if(cnt == n - 1) {
                return res;
            }
            if(unionFind.union(edge.planetA, edge.planetB)) {
                res += edge.managementCost;
                cnt++;
            }
        }
        return res;
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}