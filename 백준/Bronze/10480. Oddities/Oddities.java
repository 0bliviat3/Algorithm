import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            int x = Integer.parseInt(in.readLine());

            ans.append(x);

            if (Math.abs(x) % 2 == 1) {
                ans.append( " is odd\n");
            } else {
                ans.append(" is even\n");
            }
        }

        System.out.print(ans);
    }
}
