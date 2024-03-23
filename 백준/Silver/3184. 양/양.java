import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ3184Sol().run();
    }

    static class Animal {

        int sheep;
        int wolf;

        Animal(int sheep, int wolf) {
            this.sheep = sheep;
            this.wolf = wolf;
        }

        boolean hasMoreSheep() {
            return sheep > wolf;
        }
    }

    static class BOJ3184Sol {

        char[][] map;
        boolean[][] visit;
        int n, m;
        Queue<int[]> animalPoints;
        int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        void clear() {
            map = new char[n][m];
            visit = new boolean[n][m];
            animalPoints = new ArrayDeque<>();
        }

        boolean isWall(int x, int y) {
            return map[x][y] == '#';
        }

        boolean isSheep(int x, int y) {
            return map[x][y] == 'o';
        }

        boolean isWolf(int x, int y) {
            return map[x][y] == 'v';
        }

        void dfs(int x, int y, Animal animal) {
            if (visit[x][y]) {
                return;
            }
            visit[x][y] = true;
            if (isSheep(x, y)) {
                animal.sheep++;
            }
            if (isWolf(x, y)) {
                animal.wolf++;
            }
            for (int i = 0; i < 4; i++) {
                int dx = x + move[i][0];
                int dy = y + move[i][1];

                if (dx < 0 || dy < 0 || dx >= n || dy >= m || isWall(dx, dy) || visit[dx][dy]) {
                    continue;
                }
                dfs(dx, dy, animal);
            }
        }

        void init() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            clear();

            for (int i = 0; i < n; i++) {
                String info = in.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = info.charAt(j);
                    if (isWolf(i, j) || isSheep(i, j)) {
                        animalPoints.add(new int[] {i, j});
                    }
                }
            }
        }

        void solve() {
            Animal animalAll = new Animal(0, 0);
            Animal animal = new Animal(0, 0);

            while(!animalPoints.isEmpty()) {
                int[] point = animalPoints.poll();
                animal.sheep = 0;
                animal.wolf = 0;
                dfs(point[0], point[1], animal);

                if (animal.hasMoreSheep()) {
                    animalAll.sheep += animal.sheep;
                } else {
                    animalAll.wolf += animal.wolf;
                }

            }

            System.out.print(animalAll.sheep + " " + animalAll.wolf);
        }

        void run() {
            try {
                init();
            } catch (IOException e) {
                e.printStackTrace();
            }
            solve();
        }
    }
}
