import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MIN = 6;
    private static final int MAX = 9;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            int size = in.readLine().length();

            if (size < MIN || size > MAX) {
                ans.append("no\n");
                continue;
            }
            ans.append("yes\n");
        }

        System.out.print(ans);

    }
}
