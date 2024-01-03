import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
     * 미제출
     */
    public static void main(String[] args) {
        new BOJ1197Sol().run();
    }
}

class Node1197 implements Comparable<Node1197>{
    int start;
    int end;
    long cost;

    Node1197(int start, int end, long cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node1197 o) {
        if(this.cost < o.cost) {
            return -1;
        } else if(this.cost == o.cost) {
            return 0;
        }
        return 1;
    }
}

class BOJ1197Sol {

    private int[] parent;
    private List<Node1197> edges;

    private void clear(int n) {
        parent = new int[n + 1];
        edges = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    private int getParent(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    private void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a != b) {
            parent[b] = a;
        }
    }

    private boolean find(int a, int b) {
        return getParent(a) == getParent(b);
    }

    private void initEdges(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        long cost = Long.parseLong(st.nextToken());
        edges.add(new Node1197(start, end, cost));
    }

    private void findTree() {
        long minSum = 0L;
        Collections.sort(edges);
        for(Node1197 node : edges) {
            if(!find(node.start, node.end)) {
                minSum += node.cost;
                union(node.start, node.end);
            }
        }
        System.out.print(minSum);
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        clear(v);
        while(e-- > 0) {
            initEdges(in.readLine());
        }
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        findTree();
    }

}