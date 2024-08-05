import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final String D_DAY = "D-";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            String input = in.readLine();
            int day = Integer.parseInt(input.replace(D_DAY, ""));

            if (day <= 90) {
                cnt++;
            }
        }
        
        System.out.print(cnt);
    }
}
