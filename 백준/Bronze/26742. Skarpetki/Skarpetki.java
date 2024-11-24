import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = in.readLine().toCharArray();

        int b = 0;
        int c = 0;

        for (char now : arr) {
            if (now == 'B') {
                b++;
                continue;
            }
            c++;
        }

        System.out.print(b / 2 + c / 2);
    }
}