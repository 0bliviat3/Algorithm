import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ20833
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int sum = 0;

        while (n > 0) {
            sum += n * n * n;
            --n;
        }

        System.out.print(sum);
    }
}