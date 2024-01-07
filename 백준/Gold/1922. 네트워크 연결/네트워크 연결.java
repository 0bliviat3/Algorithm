import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new BOJ1922Sol().run();
    }
}

class Node1922 implements Comparable<Node1922> {

    int cpuA;
    int cpuB;
    int cost;

    Node1922(int cpuA, int cpuB, int cost) {
        this.cpuA = cpuA;
        this.cpuB = cpuB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node1922 o) {
       return this.cost - o.cost;
    }

}

class BOJ1922Sol {

    private List<Node1922> info;
    private List<Integer> parent;

    private void clear(int n) {
        info = new ArrayList<>();
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

    private void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a < b) {
            parent.set(b, a);
            return;
        }
        parent.set(a, b);
    }

    private boolean find(int a, int b) {
        return getParent(a) == getParent(b);
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        clear(n);

        while(m-- > 0) {
            initInfo(in.readLine());
        }
        System.out.print(kruskal(n));
    }

    private void initInfo(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int cpuA = Integer.parseInt(st.nextToken());
        int cpuB = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        info.add(new Node1922(cpuA, cpuB, cost));
    }

    private int kruskal(int n) {
        int sum = 0;
        int cnt = 0;
        Collections.sort(info);
        for(Node1922 node : info) {
            if(cnt == n - 1) {
                return sum;
            }
            if(!find(node.cpuA, node.cpuB)) {
                union(node.cpuA, node.cpuB);
                sum += node.cost;
                cnt++;
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
