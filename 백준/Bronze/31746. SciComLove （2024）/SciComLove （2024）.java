import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder("SciComLove");

        int n = Integer.parseInt(in.readLine()) % 2;

        if (n == 1) {
            ans = ans.reverse();
        }

        System.out.print(ans);
    }
}