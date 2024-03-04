import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ2637Sol().run();
    }
}

class BOJ2637Sol {

    /*
     * 역으로 생각해야함
     * 완제품부터 시작
     * 역순으로 정렬하면서 값 곱하기
     */

    private int[] inDegree;
    private int[] partCnt;
    private List<Map<Integer, Integer>> parts;
    private Queue<Integer> queue;
    private Set<Integer> basicParts;

    private void clear(int n) {
        inDegree = new int[n + 1];
        partCnt = new int[n + 1];
        parts = new ArrayList<>();
        queue = new ArrayDeque<>();
        basicParts = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            parts.add(new HashMap<>());
        }
    }

    private void initPart(String partInfo) {
        StringTokenizer st = new StringTokenizer(partInfo);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        parts.get(a).put(b, cnt); // a -> b
        inDegree[b]++;
    }

    private void topologySort(int n) {
        queue.add(n);
        partCnt[n] = 1;
        while(!queue.isEmpty()) {
            int part = queue.poll();
            if (parts.get(part).isEmpty()) {
                basicParts.add(part);
                continue;
            }
            parts.get(part).forEach((k, v) -> {
                if (--inDegree[k] == 0) {
                    queue.add(k);
                }
                partCnt[k] += partCnt[part] * v;
            });
        }
    }

    private void printAns() {
        StringBuilder ans = new StringBuilder();
        List<Integer> basic = new ArrayList<>(basicParts);
        Collections.sort(basic);
        for (int i : basic) {
            ans
            .append(i)
            .append(' ')
            .append(partCnt[i])
            .append('\n');
        }
        System.out.print(ans);
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        clear(n);
        while(m-- > 0) {
            initPart(in.readLine());
        }
        topologySort(n);
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printAns();
    }
}
