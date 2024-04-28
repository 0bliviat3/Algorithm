import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int v = n / 5;
        int i = n % 5;

        StringBuilder ans = new StringBuilder();
        for (int x = 0; x < v; x++) {
            ans.append('V');
        }

        for (int x = 0; x < i; x++) {
            ans.append('I');
        }

        System.out.print(ans);
        
    }
}
