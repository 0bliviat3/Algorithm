import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int cnt = 0;
        while (n-- > 0) {
            char[] input = in.readLine().toCharArray();
            char now = 0;
            for (char c : input) {
                if (now == '0' && c == '1') {
                    cnt++;
                    break;
                } else if (now == 'O' && c == 'I') {
                    cnt++;
                    break;
                }
                now = c;
            }
        }

        System.out.print(cnt);
    }
}
