import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long ans = 0L;
        int games = 5;
        while (games-- > 0) {
            ans += Long.parseLong(in.readLine());
        }
        System.out.print(ans);
    }
}
