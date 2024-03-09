import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ2611Sol().run();
    }
}

class Node2611 {
    int no;
    int cost;

    Node2611(int no, int cost) {
        this.no = no;
        this.cost = cost;
    }
}

class BOJ2611Sol {
    private int[] inDegree;
    private int[] dp;
    private int[] preNodes;
    private List<List<Node2611>> edges;

    private void clear(int n) {
        dp = new int[n + 1];
        inDegree = new int[n + 1];
        preNodes = new int[n + 1];
        edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
    }

    private void initEdge(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        if (b == 1) {
            b = 0;
        }
        edges.get(a).add(new Node2611(b, cost));
        inDegree[b]++;
    }

    private void topologySort(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Node2611 node : edges.get(now)) {
                if (dp[node.no] <= dp[now] + node.cost) {
                    dp[node.no] = dp[now] + node.cost;
                    preNodes[node.no] = now;
                }

                if (--inDegree[node.no] == 0) {
                    queue.add(node.no);
                }
            }
        }
    }

    private List<Integer> getPath() {
        int now = 0;
        List<Integer> path = new ArrayList<>();
        path.add(1);
        while (now != 1) {
            now = preNodes[now];
            path.add(now);
        }
        Collections.reverse(path);
        return path;
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        clear(n);
        while (m-- > 0) {
            initEdge(in.readLine());
        }

        if (n == 1) {
            System.out.println("0\n1");
            return;
        }
        topologySort(n);
        ans.append(dp[0]).append('\n');
        getPath().stream()
                .forEach(v -> ans.append(v).append(' '));
        System.out.print(ans);
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
