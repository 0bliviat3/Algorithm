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
        new BOJ14567Sol().run();
    }
}

class BOJ14567Sol {

    private List<List<Integer>> edges;
    private int[] inDegree;
    private int[] semesters;

    private void clear(int n) {
        edges = new ArrayList<>();
        inDegree = new int[n + 1];
        semesters = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        edges.get(a).add(b);
        inDegree[b]++;
    }

    private void togologySort(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                semesters[i] = 1;
            }
        }
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int next : edges.get(now)) {
                if(--inDegree[next] == 0) {
                    queue.add(next);
                    semesters[next] = semesters[now] + 1;
                }
            }
        }
    }

    private void printAns(int n) {
        StringBuilder ans = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            ans.append(semesters[i]).append(' ');
        }
        System.out.print(ans);
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        clear(n);
        while(m-- > 0) {
            init(in.readLine());
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
