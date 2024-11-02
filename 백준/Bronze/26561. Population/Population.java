import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ26561
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            int d = time / 7;
            int b = time / 4;

            ans.append(start - d + b).append('\n');
        }

        System.out.print(ans);
    }
}