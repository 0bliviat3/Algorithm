import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int max = 0;

        int n = 3;
        while (n-- > 0) {
            int now = Integer.parseInt(in.readLine());
            sum += now;
            max = Math.max(max, now);
        }

        if ((max << 1) == sum) {
            System.out.print(1);
            return;
        }
        System.out.print(0);
    }
}
