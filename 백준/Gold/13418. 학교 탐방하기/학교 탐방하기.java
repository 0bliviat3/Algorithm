import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

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


public class Main {
    public static void main(String[] args) {
        new BOJ13418Sol(
            new UnionFind(),
            new PriorityQueue<>(),
            new PriorityQueue<>((a, b) -> {
                return b.cost - a.cost;
            })).run();
    }
}

class Node13418 implements Comparable<Node13418> {
    int start;
    int end;
    int cost;

    Node13418(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node13418 o) {
        return this.cost - o.cost;
    }
}

class BOJ13418Sol {

    private static final String EASY = "1";
    private final UnionFind unionFind;
    private final AbstractQueue<Node13418> minHeap;
    private final AbstractQueue<Node13418> maxHeap;

    BOJ13418Sol(
        final UnionFind unionFind,
        final AbstractQueue<Node13418> minHeap,
        final AbstractQueue<Node13418> maxHeap) {
            this.unionFind = unionFind;
            this.minHeap = minHeap;
            this.maxHeap = maxHeap;
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken());
        unionFind.clear(n);
        while(m-- > -1) {
            init(in.readLine());
        }
        int max = kruskal(maxHeap, n);
        unionFind.clear(n);
        int min = kruskal(minHeap, n);
        System.out.print((int) (Math.pow(max, 2) - Math.pow(min, 2)));
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        if(st.nextToken().equals(EASY)) {
            minHeap.add(new Node13418(start, end, 0));
            maxHeap.add(new Node13418(start, end, 0));
            minHeap.add(new Node13418(end, start, 0));
            maxHeap.add(new Node13418(end, start, 0));
            return;
        }
        maxHeap.add(new Node13418(start, end, 1));
        maxHeap.add(new Node13418(start, end, 1));
        minHeap.add(new Node13418(end, start, 1));
        maxHeap.add(new Node13418(end, start, 1));
    }

    private int kruskal(AbstractQueue<Node13418> heap, int n) {
        int costs = 0;
        int cnt = 0;
        while(!heap.isEmpty()) {
            Node13418 node = heap.remove();
            if(unionFind.union(node.start, node.end)) {
                costs += node.cost;
                if(++cnt == n - 1) {
                    return costs;
                }
            }
        }
        return costs;
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
