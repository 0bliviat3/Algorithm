import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new BOJ2636Sol().run();
    }

    static class Spot {
        int x;
        int y;

        Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class BOJ2636Sol {

        int n, m;
        boolean[][] map;
        boolean[][] visit;
        Queue<Spot> contacts;
        Queue<Spot> bfsQueue;
        int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        void clear() {
            map = new boolean[n][m];
            visit = new boolean[n][m];
            contacts = new ArrayDeque<>();
            bfsQueue = new ArrayDeque<>();
        }

        void init() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            clear();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = st.nextToken().equals("0");
                }
            }
        }

        boolean bfs() { // 현재 녹을 치즈를 찾는다.
            boolean flag = false;
            if (bfsQueue.isEmpty()) {
                bfsQueue.add(new Spot(0, 0));
                visit[0][0] = true;
            }
            while(!bfsQueue.isEmpty()) {
                Spot now = bfsQueue.poll();
                
                for(int i = 0; i < 4; i++) {
                    int dx = now.x + move[i][0];
                    int dy = now.y + move[i][1];

                    if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                        continue;
                    }
                    if (visit[dx][dy]) {
                        continue;
                    }
                    visit[dx][dy] = true;
                    if (!map[dx][dy]) { // 치즈인 경우
                        contacts.add(new Spot(dx, dy));
                        flag = true; // 치즈를 찾은 경우
                        continue;
                    }
                    bfsQueue.add(new Spot(dx, dy));
                }
            }
            return flag;
        }

        int melt() { // 치즈 녹이기
            int cnt = contacts.size();
            while (!contacts.isEmpty()) {
                Spot cheese = contacts.poll();
                visit[cheese.x][cheese.y] = false;
                map[cheese.x][cheese.y] = true;
                bfsQueue.add(cheese);
            }
            return cnt;
        }

        String calculateTime() {
            int time = 0;
            int cnt = 0;

            while(bfs()) {
                cnt = melt();
                ++time;
            }


            return time + "\n" + cnt;
        }

        void run() {
            try {
                init();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print(calculateTime());
        }

    }

}
