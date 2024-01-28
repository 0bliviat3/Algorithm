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
        new BOJ16234Sol().run();
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class BOJ16234Sol {
    private int[][] metrix;
    private int[][] nextMetrix;
    private boolean[][] visit;
    private int L, R, n;
    private static final int[][] move = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private void clear() {
        metrix = new int[n][n];
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        clear();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < n; j++) {
                metrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean run = true;
        int day = 0;
        while(run) {
            run = false;
            visit = new boolean[n][n];
            nextMetrix = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visit[i][j]) {
                        continue;
                    }
                    if(bfs(new Point(i, j))) {
                        run = true;
                    }
                }
            }
            metrix = nextMetrix;
            if(run) {
                day++;
            }
        }
        System.out.print(day);
    }

    private boolean bfs(Point start) {
        boolean flag = false;
        int sum = metrix[start.x][start.y];
        visit[start.x][start.y] = true;
        List<Point> oneTeam = new ArrayList<>();
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        oneTeam.add(start);
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int dx = move[i][0] + now.x;
                int dy = move[i][1] + now.y;
                if(dx < 0 || dy < 0 || dx >= n || dy >= n) {
                    continue;
                }
                if(visit[dx][dy]) {
                    continue;
                }
                
                int gap = Math.abs(metrix[now.x][now.y] - metrix[dx][dy]);
                if(gap >= L && gap <= R) {
                    visit[dx][dy] = true;              
                    flag = true;
                    Point next = new Point(dx, dy);
                    queue.add(next);
                    oneTeam.add(next);
                    sum += metrix[dx][dy];
                } else {
                    nextMetrix[dx][dy] = metrix[dx][dy];
                }
            }
        }
        sum /= oneTeam.size();
        for(Point team : oneTeam) {
            nextMetrix[team.x][team.y] = sum;
        }
        return flag;
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
