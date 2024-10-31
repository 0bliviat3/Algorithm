import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ28453
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        in.readLine();

        StringTokenizer st = new StringTokenizer(in.readLine());
        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());

            if (val == 300) {
                ans.append(1);
            } else if (val >= 275) {
                ans.append(2);
            } else if (val >= 250) {
                ans.append(3);
            } else {
                ans.append(4);
            }
            ans.append(' ');
        }

        System.out.print(ans);
    }
}