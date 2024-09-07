import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        int val = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            ans.append(now - val).append(' ');
        }

        System.out.print(ans);
    }
}
