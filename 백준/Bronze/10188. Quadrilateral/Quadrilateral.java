import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        StringBuilder ans = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            String x = "X";
            String now = "";
            for (int i = 0; i < m; i++) {
                now += x;
            }
            for (int i = 0; i < l; i++) {
                ans.append(now).append('\n');
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }
}