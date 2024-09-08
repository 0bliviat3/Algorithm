import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String input = null;

        while (!(input = in.readLine()).equals("END")) {
            ans.append(new StringBuilder(input).reverse()).append('\n');
        }

        System.out.print(ans);
    }
}
