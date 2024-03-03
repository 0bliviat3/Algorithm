import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ10942Sol().run();
    }
}

class BOJ10942Sol {

    private boolean[][] isPalindrome;
    private int[] numbers;

    private void clear(int n) {
        isPalindrome = new boolean[n + 1][n + 1];
        numbers = new int[n + 1];
    }

    private void setNumbers(String input, int n) {
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            isPalindrome[i][i] = true;
            if(numbers[i - 1] == numbers[i]) {
                isPalindrome[i - 1][i] = true;
            }
        }
    }

    private void setPalindrome(int n) {
        for(int j = 2; j < n; j++) {
            for(int i = 1; i < n; i++) {
                if (i + 1 <= n && i + j <= n && isPalindrome[i + 1][i + j - 1] && numbers[i] == numbers[i + j]) {
                    isPalindrome[i][i + j] = true;
                }
            }
        }
    }

    private int query(String query) {
        StringTokenizer st = new StringTokenizer(query);
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        if (isPalindrome[s][e]) {
            return 1;
        }
        return 0;
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        clear(n);
        setNumbers(in.readLine(), n);
        setPalindrome(n);
        int m = Integer.parseInt(in.readLine());
        while(m-- > 0) {
            ans.append(query(in.readLine())).append('\n');
        }
        System.out.print(ans);
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
