import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int b = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            b = Math.min(b, Integer.parseInt(in.readLine()));
        }

        for (int i = 0; i < 2; i++) {
            d = Math.min(d, Integer.parseInt(in.readLine()));
        }

        System.out.print(b + d - 50);
    }
}