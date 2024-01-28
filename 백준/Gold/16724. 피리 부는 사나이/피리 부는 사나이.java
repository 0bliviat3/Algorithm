import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ16724Sol().run();
    }
}

class BOJ16724Sol {

    private int n, m;
    private int[][] visit; // 집합그룹
    private char[][] metrix;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void clear() {
        visit = new int[n][m];
        metrix = new char[n][m];
    }

    private int[] move(char way) {
        if(way == 'U') {
            return move[0];
        } else if(way == 'D') {
            return move[1];
        } else if(way == 'L') {
            return move[2];
        }
        return move[3];
    }

    private int dfs(int x, int y, int val) {
        if(visit[x][y] != 0) {
            return visit[x][y];
        }
        visit[x][y] = val;
        int[] move = move(metrix[x][y]);
        int dx = move[0] + x;
        int dy = move[1] + y;
        // 이 조건은 없어도 통과한다.
        if(dx < 0 || dy < 0 || dx >= n || dy >= m) {
            return visit[x][y];
        }
        return dfs(dx, dy, val);
    }

    private int countSafeZone() {
        int cnt = 0;
        int val = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visit[i][j] != 0) {
                    continue;
                }    
                if(dfs(i, j, val) == visit[i][j]) {
                    cnt++;
                }
                val++;
            }
        }
        return cnt;
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        clear();
        for(int i = 0; i < n; i++) {
            metrix[i] = in.readLine().toCharArray();
        }

        System.out.print(countSafeZone());
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
