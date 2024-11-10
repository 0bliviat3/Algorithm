import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        String semi = null;

        int n = 7;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String val = st.nextToken();
            int now = Integer.parseInt(st.nextToken());
            if (max < now) {
                semi = val;
                max = now;
            }
        }

        System.out.print(semi);
    }
}