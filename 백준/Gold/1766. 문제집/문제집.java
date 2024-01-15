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
        new BOJ1766Sol().run();
    }
}

class BOJ1766Sol {

    private static final String EMPTY = " ";
    private int[] inDegree;
    private List<List<Integer>> edges;
    private List<Integer> flow;

    private void clear(int n) {
        inDegree = new int[n + 1];
        edges = new ArrayList<>();
        flow = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
    }

    private void add(String input) {
        StringTokenizer st = new StringTokenizer(input, EMPTY);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        edges.get(a).add(b); // a -> b
        inDegree[b]++; // b 진입차수 up
    }

    private void togologySort(int n) {
        AbstractQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                heap.add(i);
            }
        }
        while(!heap.isEmpty()) {
            int now = heap.poll();
            flow.add(now);
            for(int next : edges.get(now)) {
                if(--inDegree[next] == 0) {
                    heap.add(next);
                }
            }
        }
    }

    private void printAns() {
        StringBuilder ans = new StringBuilder();
        for(int i : flow) {
            ans.append(i).append(EMPTY);
        }
        System.out.print(ans);
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), EMPTY);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        clear(n);
        while(m-- > 0) {
            add(in.readLine());
        }
        togologySort(n);
        printAns();
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
