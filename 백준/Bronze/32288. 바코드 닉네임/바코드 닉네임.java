import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String input = in.readLine();

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 'l') {
                ans.append('L');
                continue;
            }
            ans.append('i');
        }

        System.out.print(ans);
        
    }
}