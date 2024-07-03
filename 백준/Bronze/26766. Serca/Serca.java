import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final String MIND = " @@@   @@@ \n@   @ @   @\n@    @    @\n@         @\n @       @ \n  @     @  \n   @   @   \n    @ @    \n     @     \n";
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        
        while (n-- > 0) {
            ans.append(MIND);
        }

        System.out.print(ans);
    }
}
