import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final String WD = "SciComLove";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            ans.append(WD).append('\n');
        }

        System.out.print(ans);
    
    }
}