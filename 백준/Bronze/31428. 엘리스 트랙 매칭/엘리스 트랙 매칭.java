import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ31428
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        String val = in.readLine();
        int cnt = 0;

        while (st.hasMoreTokens()) {
            if (val.equals(st.nextToken())) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}