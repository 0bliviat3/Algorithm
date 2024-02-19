import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        new BOJ9466Sol().run();
    }
}

class BOJ9466Sol {

    private boolean[] visit;
    private boolean[] cycles;
    private int[] members;

    private void clear(int n) {
        visit = new boolean[n + 1];
        cycles = new boolean[n + 1];
        members = new int[n + 1];
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        AtomicInteger count = new AtomicInteger();
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            clear(n);
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int i = 1; i <= n; i++) {
                members[i] = Integer.parseInt(st.nextToken());
            }
            count.set(0);
            for(int i = 1; i <= n; i++) {
                if(!cycles[i]) {
                    dfs(i, count);
                }
            }
            ans.append(n - count.get()).append('\n');
        }
        System.out.print(ans);
    }

    private void dfs(int member, AtomicInteger count) {
        if(visit[member]) {
            cycles[member] = true;
            count.incrementAndGet();
        }else {
            visit[member] = true;
        }
        if(!cycles[members[member]]) {
            dfs(members[member], count);
        }
        visit[member] = false;
        cycles[member] = true;
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}