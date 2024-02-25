import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ2342Sol().run();
    }
}

class BOJ2342Sol {

    private int[][][] dp;
    private List<Integer> steps;

    private void clear(int n) {
        dp = new int[5][5][n];
    }

    private int getCost(int step, int now) {
        if (now == 0) {
            return 2;
        }
        if (step == now) {
            return 1;
        }
        if (Math.abs(step - now) == 2) {
            return 4;
        }
        return 3;
    }

    private int dance(int left, int right, int step, int n) {
        if (step == n) {
            return 0;
        }
        if (dp[left][right][step] != 0) {
            return dp[left][right][step];
        }
        int nextLeft = dance(steps.get(step), right, step + 1, n) + getCost(steps.get(step), left);
        int nextRight = dance(left, steps.get(step), step + 1, n) + getCost(steps.get(step), right);
        return dp[left][right][step] = Math.min(nextLeft, nextRight);
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        steps = new ArrayList<>();
        String token = null;
        int n = 0;
        while(!(token = st.nextToken()).equals("0")) {
            steps.add(Integer.parseInt(token));
            n++;
        }
        clear(n);
        System.out.print(dance(0, 0, 0, n));
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
