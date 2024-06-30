import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = 5;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(in.readLine());

            if (now < 40) {
                sum += 40;
            } else {
                sum += now;
            }
        }

        System.out.print(sum / n);
    }
}
