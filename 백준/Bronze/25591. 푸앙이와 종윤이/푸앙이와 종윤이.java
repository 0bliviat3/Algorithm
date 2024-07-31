import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = 100 - Integer.parseInt(st.nextToken());
        int b = 100 - Integer.parseInt(st.nextToken());

        int c = 100 - (a + b);
        int d = a * b;
        int q = d / 100;
        int r = d % 100;

        System.out.print(String.format("%d %d %d %d %d %d\n%d %d", a, b, c, d, q, r, (c + q), r));
    }
}
