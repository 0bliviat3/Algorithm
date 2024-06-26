import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final char PIXEL = '=';
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            int m = Integer.parseInt(in.readLine());
            while (m-- > 0) {
                ans.append(PIXEL);
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }
}
