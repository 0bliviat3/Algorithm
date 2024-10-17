import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        
        while (n-- > 0) {
            char[] arr = in.readLine().toCharArray();
            char now = 0;
            for (char c : arr) {
                if (c == now) {
                    continue;
                }
                now = c;
                ans.append(c);
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }
}