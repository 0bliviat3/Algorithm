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
        new BOJ2056Sol().run();
    }
}

class BOJ2056Sol {
    /*
     * 위상정렬 + DP
     * 1. 입력 : 노드의 번호, 노드의 초, 인접관계
     * 2. 간선제거하면서 DP
     * 3. 모든 노드를 방문하면 최소시간 출력
     */

    private int[] inDegree;
    private int[] secs;
    private int[] times;
    private List<List<Integer>> edges;

    private void clear(int n) {
        inDegree = new int[n + 1];
        secs = new int[n + 1];
        times = new int[n + 1];
        edges = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
    }

    private void init(String input, int nodeNo) {
        StringTokenizer st = new StringTokenizer(input, " ");
        secs[nodeNo] = Integer.parseInt(st.nextToken());
        inDegree[nodeNo] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < inDegree[nodeNo]; i++) {
            edges.get(Integer.parseInt(st.nextToken()))
            .add(nodeNo);
        }
    }

    private void togologySort(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                times[i] = secs[i];
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int next : edges.get(now)) {
                times[next] = Math.max(times[next], secs[next] + times[now]);
                if(--inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }

    private int getMinTime() {
        int time = 0;
        for(int i : times) {
            time = Math.max(i, time);
        }
        return time;
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        clear(n);
        for(int i = 1; i <= n; i++) {
            init(in.readLine(), i);
        }
        togologySort(n);
        System.out.print(getMinTime());
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
