import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int sum = 0;
        int now = 0;
        while (st.hasMoreTokens()) {
            now = Integer.parseInt(st.nextToken());
            sum += now;
        }

        sum -= now;

        int ans = now * 4 - sum;
        ans = (ans < 0) ? 0 : ans;

        System.out.print(ans);
    }
}