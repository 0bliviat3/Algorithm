import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
     * 가는길은 위상정렬
     * 역추적은 bfs
     */
    public static void main(String[] args) {
        new BOJ1948Sol().run();
    }
}

class Node1948 {
    int no;
    int time;
    
    Node1948(int no, int time) {
        this.no = no;
        this.time = time;
    }
}

class BOJ1948Sol {
    private int[] dp;
    private int[] inDegree;
    private List<List<Node1948>> edgesA; //basic edges
    private List<List<Node1948>> edgesB; //reverse edges

    private void clear(int n) {
        dp = new int[n + 1];
        inDegree = new int[n + 1];
        edgesA = new ArrayList<>();
        edgesB = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edgesA.add(new ArrayList<>());
            edgesB.add(new ArrayList<>());
        }
    }

    private void initEdge(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        edgesA.get(a).add(new Node1948(b, time));
        edgesB.get(b).add(new Node1948(a, time));
        inDegree[b]++;
    }

    private void topologySort(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node1948 node : edgesA.get(cur)) {
                dp[node.no] = Math.max(dp[node.no], dp[cur] + node.time);
                if (--inDegree[node.no] == 0) {
                    queue.add(node.no);
                }
            }
        }
    }

    private int bfs(int end, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[n + 1];
        int cnt = 0;
        queue.add(end);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node1948 node : edgesB.get(cur)) {
                if (dp[node.no] == dp[cur] - node.time) {
                    cnt++;
                    if (!visit[node.no]) {
                        visit[node.no] = true;
                        queue.add(node.no);
                    }
                }
            }
        }
        return cnt;
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        clear(n);
        while(m-- > 0) {
            initEdge(in.readLine());
        }
        StringTokenizer st = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        topologySort(start);
        System.out.print(dp[n] + "\n" + bfs(end, n));
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
