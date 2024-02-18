import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ2623Sol().run();
    }
}

class BOJ2623Sol {

    private int[] inDegree;
    private List<Integer> flow;
    private List<List<Integer>> edges;

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clear(int n) {
        inDegree = new int[n + 1];
        flow = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        clear(n);
        while(m-- > 0) {
            initEdge(in.readLine());
        }
        topologySort(n);
        printAns(n);
    }

    private void initEdge(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        while (n-- > 1) {
            int from = Integer.parseInt(st.nextToken());
            edges.get(to).add(from);
            inDegree[from]++;
            to = from;
        }
    }

    private void topologySort(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int now = queue.poll();
            flow.add(now);
            for(int i : edges.get(now)) {
                if(--inDegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }

    private void printAns(int n) {
        StringBuilder ans = new StringBuilder();
        if(flow.size() < n) {
            System.out.print(0);
            return;
        }
        for(int i : flow) {
            ans.append(i).append('\n');
        }
        System.out.print(ans);
    }
}
