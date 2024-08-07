import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String ans = in.readLine();
        StringTokenizer st = new StringTokenizer(in.readLine());
        int cnt = 0;

        while (st.hasMoreTokens()) {
            if (ans.equals(st.nextToken())) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}