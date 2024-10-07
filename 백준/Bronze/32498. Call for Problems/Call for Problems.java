import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int cnt = 0;

        while (n-- > 0) {
            if (Integer.parseInt(in.readLine()) % 2 == 1) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
