import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int min = Integer.MAX_VALUE;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a <= b) {
                min = Math.min(min, b);
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }

        System.out.print(min);
    }
}
