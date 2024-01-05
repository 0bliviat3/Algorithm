import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) {
        new BOJ4386Sol().run();
    }

}

class Star {

    double x;
    double y;

    Star(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getDist(Star o) {
        return Math.sqrt(
            Math.pow(this.x - o.x, 2) 
            + Math.pow(this.y - o.y, 2));
    }
}

class Node4386 implements Comparable<Node4386> {

    int start;
    int end;
    double dist;

    Node4386(int start, int end, double dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node4386 o) {
        if(this.dist < o.dist) {
            return -1;
        }else if(this.dist > o.dist) {
            return 1;
        }
        return 0;
    }  
}

class BOJ4386Sol {

    private List<Integer> parent;
    private List<Node4386> edges;
    private List<Star> stars;

    private void clear(int n) {
        parent = new ArrayList<>();
        stars = new ArrayList<>();
        edges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
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

    private double kruskal(int n) {
        double min = 0d;
        int count = 0;
        Collections.sort(edges);
        for(Node4386 node : edges) {
            if(count == n - 1) {
                return min;
            }
            if(!find(node.start, node.end)) {
                min += node.dist;
                union(node.start, node.end);
                count++;
            }
        }
        return min;
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        stars.add(new Star(x, y));
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        clear(n);
        for(int i = 0; i < n; i++) {
            init(in.readLine());
        }
        init(n);
        System.out.print(kruskal(n));
    }

    private void init(int n) {
        for(int start = 0; start < n - 1; start++) {
            for(int end = start + 1; end < n; end++) {
                edges.add(
                    new Node4386(
                        start, end, stars.get(start)
                        .getDist(stars.get(end))));
            }
        }
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}