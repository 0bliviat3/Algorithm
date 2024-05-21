import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        if (n % 5 == 0) {
            System.out.println(n / 5);
            return;
        }
        System.out.println(n / 5 + 1);
    }
}
