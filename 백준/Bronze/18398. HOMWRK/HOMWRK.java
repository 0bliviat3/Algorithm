import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                ans.append(a + b).append(' ').append(a * b).append('\n');
            }
        }

        System.out.print(ans);
    }
}
