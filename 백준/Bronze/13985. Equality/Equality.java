import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), "+= ");

        int a = Integer.parseInt(st.nextToken());
        a += Integer.parseInt(st.nextToken());

        if (a == Integer.parseInt(st.nextToken())) {
            System.out.print("YES");
            return;
        }
        System.out.print("NO");
    }
}
