import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ16202Sol(new ArrayList<>()).run();
    }
}

class Edge16202 {
    int a;
    int b;

    Edge16202(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class BOJ16202Sol {
    
    private final List<Edge16202> edges;
    private int[] parents;
    private int n, m;

    BOJ16202Sol(final List<Edge16202> edges) {
        this.edges = edges;
    }

    private void clear() { // 턴마다 초기화
        parents = new int[n + 1];
        for(int i = 1; i <= n; i++) {
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

    private int kruskal(int start) {
        int cnt = 0;
        int cost = 0;
        for(int i = start; i < m; i++) {
            Edge16202 now = edges.get(i);
            if (union(now.a, now.b)) {
                cnt++;
                cost += i + 1;
            }
            if (cnt == n - 1) {
                return cost;
            }
        }
        return 0;
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans  = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= m; i++) {
            init(in.readLine());
        }
        int res = -1;
        for(int i = 0; i < k; i++) {
            if (res != 0) {
                clear();
                res = kruskal(i);
            }
            ans.append(res).append(' ');
        }
        System.out.println(ans);
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        edges.add(new Edge16202(a, b));
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
