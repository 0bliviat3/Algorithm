import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new BOJ1584Sol().solve();
    }

    /*
     * 1. 전체 구역 초기화
     * 2. 위험구역 할당
     * 3. 죽음구역 덮어쓰기
     * 4. 다익스트라
     */

    static class Node {
        int x;
        int y;
        int life;

        Node(int x, int y, int life) {
            this.x = x;
            this.y = y;
            this.life = life;
        }

        int compare(Node x) {
            return this.life - x.life;
        }
    }

    static class BOJ1584Sol {
        int[][] life;
        int[][] map;
        int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        final int DANGER = 1;
        final int DEATH = -1;

        void clear() {
            life = new int[501][501];
            map = new int[501][501];

            for (int i = 0; i <= 500; i++) {
                Arrays.fill(life[i], Integer.MAX_VALUE);
            }
        }

        void fillArea(final int val, String pointInfo) {
            StringTokenizer st = new StringTokenizer(pointInfo);
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++) {
                    map[i][j] = val;
                }
            }
        }

        void dijkstra() {
            AbstractQueue<Node> heap = new PriorityQueue<>(Node::compare);
            life[0][0] = 0;
            heap.add(new Node(0, 0, 0));

            while(!heap.isEmpty()) {
                Node node = heap.poll();
                for (int i = 0; i < 4; i++) {
                    int dx = node.x + move[i][0];
                    int dy = node.y + move[i][1];

                    if (dx < 0 || dy < 0 || dx > 500 || dy > 500) {
                        continue;
                    }
                    if (map[dx][dy] == DEATH) {
                        continue;
                    }
                    if (life[dx][dy] > map[dx][dy] + life[node.x][node.y]) {
                        life[dx][dy] = map[dx][dy] + life[node.x][node.y];
                        heap.add(new Node(dx, dy, life[dx][dy]));
                    }
                }
            }
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            clear();
            
            int n = Integer.parseInt(in.readLine());
            while (n-- > 0) {
                fillArea(DANGER, in.readLine());
            }
            int m = Integer.parseInt(in.readLine());
            while (m-- > 0) {
                fillArea(DEATH, in.readLine());
            }

            dijkstra();
            if (life[500][500] == Integer.MAX_VALUE) {
                System.out.print(-1);
                return;
            }
            System.out.print(life[500][500]);
        }
    }
}
