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
        new BOJ9470Sol(new ArrayDeque<>()).run();
    }
}

class Node9470 {

    int no;
    int inDegree;
    int flow;
    int flowCnt;

    Node9470(int no) {
        this.no = no;
    }

    void setfirstNode() {
        this.flow = 1;
        this.flowCnt = 1;
    }

    int decreaseInDegree() {
        return --this.inDegree;
    }

    void updateNode() {
        if(this.flowCnt > 1) {
            this.flow++;
        }
    }

    void setNode(Node9470 node) {
        if (flow < node.flow) {
            flowCnt = 1;
            flow = node.flow;
        } else if (flow == node.flow) {
            flowCnt++;
        }
    }

}

class BOJ9470Sol {

    private Node9470[] nodes;
    private List<List<Integer>> edges;
    private final Queue<Node9470> queue;

    BOJ9470Sol(final Queue<Node9470> queue) {
        this.queue = queue;
    }

    private void clear(int m) {
        nodes = new Node9470[m + 1];
        edges = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            edges.add(new ArrayList<>());
            nodes[i] = new Node9470(i);
        }
    }

    private void initEdge(String edge) {
        StringTokenizer st = new StringTokenizer(edge);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        edges.get(a).add(b); // a -> b
        nodes[b].inDegree++;
    }

    private void topologySort(int m) {
        for (int i = 1; i <= m; i++) {
            if (nodes[i].inDegree == 0) {
                nodes[i].setfirstNode();
                queue.add(nodes[i]);
            }
        }
        while(!queue.isEmpty()) {
            Node9470 now = queue.poll();
            now.updateNode();
            for (int i : edges.get(now.no)) {
                nodes[i].setNode(now);
                if (nodes[i].decreaseInDegree() == 0) {
                    queue.add(nodes[i]);
                }
            }
        }
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int test = Integer.parseInt(in.readLine());
        while(test-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String k = st.nextToken();
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            clear(m);
            while(p-- > 0) {
                initEdge(in.readLine());
            }
            topologySort(m);
            ans.append(k).append(' ').append(nodes[m].flow).append('\n');
        }
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
