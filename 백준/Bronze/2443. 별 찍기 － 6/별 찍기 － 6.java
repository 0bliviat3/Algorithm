import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        int m = 2 * n - 1;

        for (int i = 0; i < n; i++) {
            int cnt = i;
            for (int j = m - i; j > 0; j--) {
                if (cnt-- > 0) {
                    ans.append(' ');
                    continue;
                }
                ans.append('*');
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }
}