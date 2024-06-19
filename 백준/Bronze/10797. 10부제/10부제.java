import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String n = in.readLine();

        String[] arr = in.readLine().split(" ");

        int cnt = 0;

        for (String val : arr) {
            if (val.equals(n)) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
