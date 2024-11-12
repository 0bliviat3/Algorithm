import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = in.readLine().toCharArray();
        int a = 0;
        int b = 0;

        for (char c : arr) {
            if (c == 'A') {
                a++;
                continue;
            }
            b++;
        }

        System.out.println(String.format("%d : %d", a, b));
    }
}
