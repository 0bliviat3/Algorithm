import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new BOJ1261Sol().run();
    }

}

class Spot implements Comparable<Spot> {
    int x;
    int y;
    int cnt;

    Spot(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Spot o) {
        return this.cnt - o.cnt;
    }
}

class BOJ1261Sol {
    private int[][] metrix;
    private boolean[][] visit;
    private int[][] cnts;
    private int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private int n, m;

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        clear();
        for(int i = 0; i < m; i++) {
            String line = in.readLine();
            for(int j = 0; j < n; j++) {
                metrix[i][j] = line.charAt(j) - '0';
                cnts[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private void clear() {
        metrix = new int[m][n];
        visit = new boolean[m][n];
        cnts = new int[m][n];
    }

    private void dijkstra() {
        PriorityQueue<Spot> heap = new PriorityQueue<>();
        heap.add(new Spot(0, 0, 0));
        cnts[0][0] = 0;
        while(!heap.isEmpty()) {
            Spot now = heap.poll();
            if(visit[now.x][now.y]) {
                continue;
            }
            visit[now.x][now.y] = true;
            for(int i = 0; i < 4; i++) {
                int x = now.x + move[i][0];
                int y = now.y + move[i][1];
                if(x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                int nextCnt = now.cnt + metrix[x][y];
                if(nextCnt < cnts[x][y]) {
                    cnts[x][y] = nextCnt;
                    heap.add(new Spot(x, y, nextCnt));
                }
            }
        }
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dijkstra();
        System.out.print(cnts[m - 1][n - 1]);
    }


}