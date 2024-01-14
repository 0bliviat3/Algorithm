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
        new BOJ3665Sol().run();
    }
}

class BOJ3665Sol {

    /*
     * 1. 작년 순서 입력
     * 1.1 작년 순서 대로 단방향 그래프 생성
     * 2. 작년 순서와 바뀐 경우 입력
     * 2.1 작년 순서와 바뀐 부분 단방향 그래프 수정
     * 3. 사이클이 생긴다면 예외 처리
     * 
     */
    private static final String EMPTY = " ";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private int[] inDegrees;
    private boolean[][] metrix;
    private int[] rank;
    private List<Integer> currentRank;

    private void clear(int n) {
        inDegrees = new int[n + 1];
        metrix = new boolean[n + 1][n + 1];
        rank = new int[n + 1];
        currentRank = new ArrayList<>();
    }

    private void initRank(String input, int n) {
        StringTokenizer st = new StringTokenizer(input, EMPTY);
        for (int i = 1; i <= n; i++) {
            rank[Integer.parseInt(st.nextToken())] = i;
        }
    }

    private void setLastYearMetrix(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                } else if (rank[i] < rank[j]) {
                    metrix[i][j] = true;
                    inDegrees[i]++;
                }
            }
        }
    }

    private void setCurrentYearMetrix(String input) {
        StringTokenizer st = new StringTokenizer(input, EMPTY);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (metrix[a][b]) {
            metrix[a][b] = false;
            metrix[b][a] = true;
            inDegrees[a]--;
            inDegrees[b]++;
        } else if (metrix[b][a]) {
            metrix[b][a] = false;
            metrix[a][b] = true;
            inDegrees[b]--;
            inDegrees[a]++;
        }
    }

    private boolean topologySort(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                return false;
            }
            int now = queue.remove();
            currentRank.add(now);
            for (int j = 1; j <= n; j++) {
                if (!metrix[j][now]) {
                    continue;
                }
                if (--inDegrees[j] == 0) {
                    queue.add(j);
                }
            }
        }
        return true;
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int testCase = Integer.parseInt(in.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(in.readLine());
            clear(n);
            initRank(in.readLine(), n);
            setLastYearMetrix(n);
            int m = Integer.parseInt(in.readLine());
            while (m-- > 0) {
                setCurrentYearMetrix(in.readLine());
            }
            if (topologySort(n)) {
                for (int i = n - 1; i >= 0; i--) {
                    ans.append(currentRank.get(i)).append(EMPTY);
                }
            } else {
                ans.append(IMPOSSIBLE);
            }
            ans.append('\n');
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
