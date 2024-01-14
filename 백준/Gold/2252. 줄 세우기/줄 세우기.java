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
        new BOJ2252SOl().run();
    }
    
}

class BOJ2252SOl {

    private static final String ERROR_CODE = "[ERROR] 사이클 발생";
    private static final String EMPTY = " ";
    private int[] inDegrees;
    private List<List<Integer>> edges;
    private List<Integer> ans;

    private void clear(int n) {
        inDegrees = new int[n + 1];
        edges = new ArrayList<>();
        ans = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
    }

    private void add(String input) {
        StringTokenizer st = new StringTokenizer(input, EMPTY);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        edges.get(a).add(b);
        inDegrees[b]++;
    }

    private void topologySort(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            if(inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        for(int i = 0; i < n; i++) {
            if(queue.isEmpty()) {
                throw new IllegalArgumentException(ERROR_CODE);
            }
            int now = queue.remove();
            ans.add(now); // 줄세우기
            for(int next : edges.get(now)) {
                if(--inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }

    private void printAns() {
        StringBuilder ans = new StringBuilder();
        for(int i : this.ans) {
            ans.append(i).append(EMPTY);
        }
        System.out.print(ans);
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        clear(n);
        while(m-- > 0) {
            add(in.readLine());
        }
        topologySort(n);
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printAns();
    }
}
