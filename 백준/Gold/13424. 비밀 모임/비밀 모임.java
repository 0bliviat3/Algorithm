import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new BOJ13424Sol().solve();
    }

    static class BOJ13424Sol {
        int[][] dists;
        List<Integer> friends;

        void clear(int n) {
            friends = new ArrayList<>();
            dists = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int getMinRoom(int n) {
            int min = Integer.MAX_VALUE;
            int room = 0;

            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int friend : friends) {
                    sum += dists[i][friend];
                }
                if (sum < min) {
                    min = sum;
                    room = i;
                }
            }

            return room;
        }

        void init(String input) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            dists[a][b] = dists[b][a] = dist;
        }

        void initFriend(String input) {
            StringTokenizer st = new StringTokenizer(input);
            while(st.hasMoreTokens()) {
                friends.add(Integer.parseInt(st.nextToken()));
            }
        }

        void floyd(int n) {
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        dists[i][j] = min(dists[i][j], dists[i][k], dists[k][j]);
                    }
                }
            }
        }

        int min(int a, int b, int c) {
            if (b == Integer.MAX_VALUE || c == Integer.MAX_VALUE) {
                return a;
            }
            return Math.min(a, b + c);
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder ans = new StringBuilder();
            int t = Integer.parseInt(in.readLine());

            while(t-- > 0) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                clear(n);
                while (m-- > 0) {
                    init(in.readLine());
                }
                in.readLine();
                initFriend(in.readLine());
                floyd(n);
                ans.append(getMinRoom(n)).append('\n');
            }

            System.out.print(ans);
        }


    }
}
