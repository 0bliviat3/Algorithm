import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        new BOJ2665Sol().run();
    }

    static class Room {
        int x;
        int y;
        int cost;

        Room(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        int compare(Room r) {
            return this.cost - r.cost;
        }
    }

    static class BOJ2665Sol {

        int n;
        int[][] map;
        int[][] costs;
        int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        void clear() {
            map = new int[n][n];
            costs = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(costs[i], Integer.MAX_VALUE);
            }
        }

        int sumINF(int x, int y) {
            if (x == Integer.MAX_VALUE || y == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return x + y;
        }

        void dijkstra() {
            costs[0][0] = 0;
            AbstractQueue<Room> heap = new PriorityQueue<>(Room::compare);
            heap.add(new Room(0, 0, 0));

            while(!heap.isEmpty()) {
                Room now = heap.poll();
                if (now.cost > costs[now.x][now.y]) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int x = now.x + move[i][0];
                    int y = now.y + move[i][1];

                    if (x < 0 || y < 0 || x >= n || y >= n) {
                        continue;
                    }
                    
                    if (costs[x][y] > sumINF(map[x][y], now.cost)) {
                        costs[x][y] = sumINF(map[x][y], now.cost);
                        heap.add(new Room(x, y, costs[x][y]));
                    }
                }
            }
        }

        void init() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(in.readLine());

            clear();

            for (int i = 0; i < n; i++) {
                String input = in.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.abs(input.charAt(j) - '1');
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
            System.out.print(costs[n - 1][n - 1]);
        }

    }
}