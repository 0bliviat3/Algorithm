import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new BOJ1647Sol().run();
    }
}

class Node1647 implements Comparable<Node1647> {
    int start;
    int end;
    int cost;

    Node1647(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node1647 o) {
        return this.cost - o.cost;
    }
}

class BOJ1647Sol {

    private List<Integer> parent;
    private List<Node1647> edges;

    private void clear(int n) {
        edges = new ArrayList<>();
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

    private boolean find(int a, int b) {
        return getParent(a) == getParent(b);
    }

    private void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a != b) {
            parent.set(b, a);
        }
    }

    private int kruskal(int n) {
        int sum = 0;
        int unionCnt = 0;
        Collections.sort(edges);
        for(Node1647 node : edges) {
            if(!find(node.start, node.end)) {
                if(unionCnt == n - 2) {
                    return sum;
                }
                sum += node.cost;
                union(node.start, node.end);
                unionCnt++;
            }
        }
        return sum;
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        edges.add(new Node1647(start, end, cost));
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        clear(n);
        while(m-- > 0) {
            init(in.readLine());
        }
        System.out.print(kruskal(n));
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}