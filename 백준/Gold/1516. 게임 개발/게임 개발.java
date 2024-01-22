import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ1516Sol().run();
    }
}

class BOJ1516Sol {
    
    private static final String END = "-1";
    private static final char LINE = '\n';
    private int[] inDegrees;
    private int[] times;
    private int[] res;
    private List<List<Integer>> edges;
    

    private void clear(int n) {
        times = new int[n + 1];
        inDegrees = new int[n + 1];
        res = new int[n + 1];
        edges = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
    }

    private void initEdge(String input, int node) {
        StringTokenizer st = new StringTokenizer(input);
        String token = st.nextToken();
        times[node] = Integer.parseInt(token);
        while(!(token = st.nextToken()).equals(END)) {
            edges.get(Integer.parseInt(token)).add(node);
            inDegrees[node]++;
        }
    }

    private void togologySort(int n) {
        AbstractQueue<Node1516> queue = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            if(inDegrees[i] == 0) {
                queue.add(new Node1516(i, times[i]));
                res[i] = times[i];
            }
        }
        while(!queue.isEmpty()) {
            Node1516 now = queue.poll();
            for(int next : edges.get(now.node)) {
                int max = Math.max(now.time, res[now.node]);
                if(--inDegrees[next] == 0) {
                    queue.add(new Node1516(next, times[next]));
                }
                res[next] = Math.max(res[next], max + times[next]);
            }
        }
    }

    private void printAns(int n) {
        StringBuilder ans = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            ans.append(res[i]).append(LINE);
        }
        System.out.print(ans);
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        clear(n);
        for(int i = 1; i <= n; i++) {
            initEdge(in.readLine(), i);
        }
        togologySort(n);
        printAns(n);
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Node1516 implements Comparable<Node1516> {
    int node;
    int time;

    Node1516(int node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public int compareTo(Node1516 o) {
        return this.time - o.time;
    }
}
