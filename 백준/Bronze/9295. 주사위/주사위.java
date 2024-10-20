import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ9295
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String cases = "Case %d: %d\n";
        int n = Integer.parseInt(in.readLine());

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int sum = Integer.parseInt(st.nextToken());
            sum += Integer.parseInt(st.nextToken());
            ans.append(String.format(cases, i, sum));
        }

        System.out.print(ans);
    }
}