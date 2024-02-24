import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ1368Sol().run();
    }
}

class FieldEdge {
    int field;
    int cost;

    FieldEdge(int field, int cost) {
        this.field = field;
        this.cost = cost;
    }
}

class BOJ1368Sol {

    private int n, ans;
    private int[][] edges;
    private boolean[] visit;
    private AbstractQueue<FieldEdge> heap;

    private void clear() {
        edges = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        heap = new PriorityQueue<>((itemA, itemB) -> {
            return itemA.cost - itemB.cost;
        });
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        clear();
        for (int i = 1; i <= n; i++) {
            heap.add(new FieldEdge(i, Integer.parseInt(in.readLine())));
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= n; j++) {
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private void prim() {
        while(!heap.isEmpty()) {
            FieldEdge now = heap.poll();
            if(!visit[now.field]) {
                visit[now.field] = true;
                ans += now.cost;
                for(int i = 1; i <= n; i++) {
                    heap.add(new FieldEdge(i, edges[now.field][i]));
                }
            }
        }
        System.out.print(ans);
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prim();
    }

}