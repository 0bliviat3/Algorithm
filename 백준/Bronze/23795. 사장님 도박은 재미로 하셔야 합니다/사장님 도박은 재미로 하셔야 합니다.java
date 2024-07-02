import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = null;

        int sum = 0;
        while (!(input = in.readLine()).equals("-1")) {
            sum += Integer.parseInt(input);
        }

        System.out.print(sum);
    }
}
