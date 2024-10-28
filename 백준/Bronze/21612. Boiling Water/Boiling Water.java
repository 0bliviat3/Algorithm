import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ21612
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        n = n * 5 - 400;

        ans.append(n).append('\n');

        if (n > 100) {
            ans.append(-1);
        } else if (n < 100) {
            ans.append(1);
        } else {
            ans.append(0);
        }

        System.out.print(ans);
    }
}