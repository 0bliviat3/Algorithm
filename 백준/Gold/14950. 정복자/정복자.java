import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ14950Sol(new UnionFind()).run();
    }
}

class Edge14950 implements Comparable<Edge14950> {
    int start;
    int end;
    int cost;
    Edge14950(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge14950 o) {
        return this.cost - o.cost;
    }
}

class BOJ14950Sol {
    private final UnionFind unionFind;
    private AbstractQueue<Edge14950> heap;
    private int n, m, t;

    BOJ14950Sol(final UnionFind unionFind) {
        this.unionFind = unionFind;
        heap = new PriorityQueue<>();
    }

    private void clear(String input) {
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        unionFind.clear(n);
    }

    private void initEdge(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        Edge14950 edge = new Edge14950(start, end, cost);
        heap.add(edge);
    }

    private int kruskal() {
        int cnt = 0;
        int cost = 0;
        int increCost = 0;
        while(!heap.isEmpty()) {
            Edge14950 edge = heap.poll();
            if(unionFind.union(edge.start, edge.end)) {
                cost += (edge.cost + increCost);
                if(++cnt == n - 1) {
                    return cost;
                }
                increCost += t;
            }
        }
        return cost;
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        clear(in.readLine());
        while(m-- > 0) {
            initEdge(in.readLine());
        }
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(kruskal());
    }

}

class UnionFind {
    
    private List<Integer> parent;

    public void clear(int n) {
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

    public boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a != b) {
            parent.set(b, a);
            return true;
        }
        return false;
    }
}


