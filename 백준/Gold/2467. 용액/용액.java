import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        new BOJ2467Sol().run();
    }
}

class BOJ2467Sol {
    
    private int[] solutions;
    private int n;

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(solve());
    }
    
    private void clear() {
        solutions = new int[n];
    }

    private void initSolution(String input) {
        clear();
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        initSolution(in.readLine());
    }

    private String solve() {
        int[] ans = new int[2];
        AtomicInteger max = new AtomicInteger(Integer.MAX_VALUE);
        for(int i = 0; i < n - 1; i++) {
            search(solutions[i], i + 1, n - 1, max, ans);
        }
        return ans[0] + " " + ans[1];
    }

    private void search(int val, int start, int end, AtomicInteger max, int[] ans) {
        while(start <= end) {
            int mid  = start + end >> 1;
            int sum = val + solutions[mid];
            if(Math.abs(sum) < max.get()) {
                ans[0] = val;
                ans[1] = solutions[mid];
                max.set(Math.abs(sum));
            }
            if(sum < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}
