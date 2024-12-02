import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        StringBuilder ans = new StringBuilder();
        while (t-- > 0) {
            int year = Integer.parseInt(in.readLine());
            int mod = year % 100;
            if (++year % mod == 0) {
                ans.append("Good\n");
                continue;
            }
            ans.append("Bye\n");
        }

        System.out.print(ans);
    }
}