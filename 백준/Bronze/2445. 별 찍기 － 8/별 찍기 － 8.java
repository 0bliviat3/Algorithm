import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= i) {
                    ans.append('*');
                    continue;
                }
                ans.append(' ');
            }
            for (int j = n; j >= 1; j--) {
                if (j <= i) {
                    ans.append('*');
                    continue;
                }
                ans.append(' ');
            }
            ans.append('\n');
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (j <= i) {
                    ans.append('*');
                    continue;
                }
                ans.append(' ');
            }
            for (int j = n; j >= 1; j--) {
                if (j <= i) {
                    ans.append('*');
                    continue;
                }
                ans.append(' ');
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }
}
