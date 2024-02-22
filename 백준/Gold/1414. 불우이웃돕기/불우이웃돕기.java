import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        new BOJ1414Sol().run();
    }
}

class Edge1414 implements Comparable<Edge1414> {
    int roomA;
    int roomB;
    int line;

    Edge1414(int roomA, int roomB, int line) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.line = line;
    }

    @Override
    public int compareTo(Edge1414 o) {
        return this.line - o.line;
    }
}

class BOJ1414Sol {
    private AbstractQueue<Edge1414> heap;
    private int[] parents;

    private void clear(int n) {
        heap = new PriorityQueue<>();
        parents = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parents[i] = i;
        }
    }

    private int find(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parents[b] = a;
            return true;
        }
        return false;
    }

    private int convert(char line) {
        if(line >= 'a') {
            return line - 'a' + 1;
        }
        return line - 'A' + 27;
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        clear(n);
        int lineSum = 0;
        for(int i = 1; i <= n; i++) {
            String lineInfo = in.readLine();
            for(int j = 1; j <= n; j++) {
                char line = lineInfo.charAt(j - 1);
                if(line == '0') {
                    continue;
                }
                int now = convert(line);
                lineSum += now;
                if(i == j) {
                    continue;
                }
                heap.add(new Edge1414(i, j, now));
            }
        }
        int res = kruskal(n);
        if(res < 0) {
            System.out.print(res);
            return;
        }
        System.out.print(lineSum - res);
    }

    private int kruskal(int n) {
        int cnt = 0;
        int sum = 0;
        if(n == 1) {
            return sum;
        }
        while(!heap.isEmpty()) {  
            Edge1414 edge = heap.poll();
            if(union(edge.roomA, edge.roomB)) {
                cnt++;
                sum += edge.line;
            }
            if(cnt == n - 1) {
                return sum;
            }
        }
        return -1;
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
