import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int max = 0;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            int now = a * (d + g);

            if (a == d + g) {
                now <<= 1;
            }

            max = Math.max(max, now);
        }

        System.out.print(max);
    }
}
