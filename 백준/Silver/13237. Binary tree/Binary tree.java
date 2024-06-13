import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {/* run */}

    static class BOJ13237Sol {

        int[] parents;
        int[] depths;

        void clear(int n) {
            parents = new int[n + 1];
            depths = new int[n + 1];
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            clear(n);

            for (int i = 1; i <= n; i++) {
                parents[i] = Integer.parseInt(in.readLine());
            }

            System.out.print(makeDepthForm(n));
        }

        int dfs(int start) {            
            if (parents[start] == -1) {
                return 0;
            }
            return dfs(parents[start]) + 1;
        }

        String makeDepthForm(int n) {
            StringBuilder ans = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (depths[i] == 0) {
                    depths[i] = dfs(i);
                }
                ans.append(depths[i]).append('\n');
            }
            return ans.toString();
        }
    }

    static {
        try {
            new BOJ13237Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
