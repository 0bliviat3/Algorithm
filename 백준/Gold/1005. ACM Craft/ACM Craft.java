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
        new BOJ1005Sol().run();
    }
}

class BOJ1005Sol {

    private int[] inDegrees;
    private int[] times;
    private int[] workTimes;
    private List<List<Integer>> edges;
    private int n;

    private void clear() {
        inDegrees = new int[n + 1];
        times = new int[n + 1];
        workTimes = new int[n + 1];
        edges = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
    }

    private void setTime(String input) {
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 1; i <= n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void setOrder(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        edges.get(a).add(b);
        inDegrees[b]++;
    }

    private void topologySort() {
        AbstractQueue<Integer> heap =  new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            if(inDegrees[i] == 0) {
                workTimes[i] = times[i];
                heap.add(i);
            }
        }
        while(!heap.isEmpty()) {
            int now = heap.poll();
            for(int next : edges.get(now)) {
                workTimes[next] = Math.max(workTimes[next], workTimes[now] + times[next]);
                if(--inDegrees[next] == 0) {
                    heap.add(next);
                }
            }
        }
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int testCase = Integer.parseInt(in.readLine());
        while(testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            clear();
            int m = Integer.parseInt(st.nextToken());
            setTime(in.readLine());
            while(m-- > 0) {
                setOrder(in.readLine());
            }
            topologySort();

            int target = Integer.parseInt(in.readLine());
            ans.append(workTimes[target]).append('\n');
        }
        System.out.print(ans);
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}