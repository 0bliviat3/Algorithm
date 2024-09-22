import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final String FIVE = "++++";
    public static final String ONE = "|";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            int now = Integer.parseInt(in.readLine());
            int x = now / 5;
            int y = now % 5;
            while (x-- > 0) {
                ans.append(FIVE).append(' ');
            }
            while (y-- > 0) {
                ans.append(ONE);
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }
}
