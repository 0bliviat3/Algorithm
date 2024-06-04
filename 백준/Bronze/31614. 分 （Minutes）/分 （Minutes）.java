import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int ans = Integer.parseInt(in.readLine()) * 60;
        ans += Integer.parseInt(in.readLine());

        System.out.print(ans);
    }
}
