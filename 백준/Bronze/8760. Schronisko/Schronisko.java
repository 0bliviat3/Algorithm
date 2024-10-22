import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ8760
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            ans
            .append((Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken())) >> 1)
            .append('\n');
        }

        System.out.print(ans);
    }
}