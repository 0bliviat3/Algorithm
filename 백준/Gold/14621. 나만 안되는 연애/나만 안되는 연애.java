import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ14621Sol(new UnionFind(), new PriorityQueue<>()).run();
    }
}

class Edge14621 implements Comparable<Edge14621> {
    int start;
    int end;
    int dist;

    Edge14621(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge14621 o) {
        return this.dist - o.dist;
    }
}

class BOJ14621Sol {
    private static final String MAN = "M";
    private final UnionFind unionFind;
    private final AbstractQueue<Edge14621> heap;
    private boolean[] mans;

    BOJ14621Sol(final UnionFind unionFind, final AbstractQueue<Edge14621> heap) {
        this.unionFind = unionFind;
        this.heap = heap;
    }

    private void clear(int n) {
        unionFind.clear(n);
        mans = new boolean[n + 1];
    }

    private void initMans(int n, String input) {
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 1; i <= n; i++) {
            if(st.nextToken().equals(MAN)) {
                mans[i] = true;
            }
        }
    }

    private void initEdges(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        if(mans[start] != mans[end]) {
            heap.add(new Edge14621(start, end, cost));
        }
    }

    private int kruskal(int n) {
        int dist = 0;
        int cnt = 0;
        while(!heap.isEmpty()) {
            
            Edge14621 edge = heap.remove();
            if(unionFind.union(edge.start, edge.end)) {
                dist += edge.dist;
                if(++cnt == n - 1) {
                    return dist;
                }                
            }
        }
        return -1;
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        clear(n);
        initMans(n, in.readLine());
        while(m-- > 0) {
            initEdges(in.readLine());
        }
        System.out.print(kruskal(n));
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
