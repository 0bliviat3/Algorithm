import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ32025
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(in.readLine());
        int w = Integer.parseInt(in.readLine());

        int r = Math.min(h, w);

        System.out.print(r * 50);
    }
}