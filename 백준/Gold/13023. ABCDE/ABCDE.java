import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {
        new BOJ13023Sol().run();
    }
    
}

class BOJ13023Sol {
    private List<List<Integer>> edges;
    private boolean[] visit;

    private void clear(int n) {
        visit = new boolean[n];
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        edges.get(a).add(b);
        edges.get(b).add(a);
    }

    private void dfs(int x, int depth, AtomicBoolean flag) {
        if (depth == 5) {
            flag.set(true);
            return;
        }    
        if (flag.get()) {
            return;
        }        
        for (int i : edges.get(x)) {
            if (visit[i]) {
                continue;
            }
            visit[x] = true;
            dfs(i, depth + 1, flag);
            visit[x] = false;
        } 
    }

    private int solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        clear(n);

        while(m-- > 0) {
            init(in.readLine());
        }

        AtomicBoolean ans = new AtomicBoolean();

        for (int i = 0; i < n; i++) {
            visit[i] = true;
            dfs(i, 1, ans);
            visit[i] = false;
        }

        if(ans.get()) {
            return 1;
        }
        return 0;
    }

    void run() {
        try {
            System.out.print(solve());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
