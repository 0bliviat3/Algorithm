import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] input = in.readLine().toCharArray();

        int cnt = input.length;
        for (char var : input) {
            if (var == ':') {
                cnt++;
            } else if (var == '_') {
                cnt += 5;
            }
        }

        System.out.print(cnt);
    }
}
