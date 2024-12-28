import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        StringBuilder ans = new StringBuilder();

        while (n-- > 0) {
            String input = in.readLine();
            int size = input.length();
            ans.append(input);

            if (input.charAt(size - 1) != '.') {
                ans.append('.');
            }

            ans.append('\n');
        }

        System.out.print(ans);
    }
}