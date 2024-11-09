import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] input = in.readLine().toCharArray();
        
        StringBuilder ans = new StringBuilder();
        for (char c : input) {
            ans.append(c);
            if (c == 'e') {
                ans.append('e');
            }
        }

        System.out.print(ans);
    }
}