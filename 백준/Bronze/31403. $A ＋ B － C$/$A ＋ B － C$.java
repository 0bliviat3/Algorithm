import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine();
        String b = in.readLine();
        int ab = Integer.parseInt(a + b);
        int c = Integer.parseInt(in.readLine());

        StringBuilder ans = new StringBuilder();
        ans.append(Integer.parseInt(a) + Integer.parseInt(b) - c).append('\n').append(ab - c);
        
        System.out.print(ans);
    }
}
