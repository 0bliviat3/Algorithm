import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ5021Sol().run();
    }
}

class BOJ5021Sol {
    private Map<String, Long> bloods;
    private Map<String, List<String>> edges;

    private void clear() {
        bloods = new HashMap<>();
        edges = new HashMap<>();
    }

    private void init(String relation) {
        StringTokenizer st = new StringTokenizer(relation);
        String child = st.nextToken();
        String parentA = st.nextToken();
        String parentB = st.nextToken();

        edges.put(child, List.of(parentA, parentB));
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        clear();

        bloods.put(in.readLine(), 1L << 50);

        while (n-- > 0) {
            init(in.readLine());
        }

        long max = -1L;
        String ans = null;
        while (m-- > 0) {
            String candidate = in.readLine();
            long blood = dfs(candidate);
            if (max < blood) {
                max = blood;
                ans = candidate;
            }
        }
        System.out.print(ans);
    }

    private long dfs(String candidate) {
        if (bloods.containsKey(candidate)) {
            return bloods.get(candidate);
        }
        if (!edges.containsKey(candidate)) {
            return 0L;
        }
        long blood = dfs(edges.get(candidate).get(0))
                + dfs(edges.get(candidate).get(1)) >> 1;
        bloods.put(candidate, blood);
        return blood;
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
