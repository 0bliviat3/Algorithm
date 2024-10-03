import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            Double val = 1d;
            StringTokenizer st = new StringTokenizer(in.readLine());
            while (st.hasMoreTokens()) {
                val *= Double.parseDouble(st.nextToken());
            }
            ans.append('$').append(String.format("%.2f", val)).append('\n');
        }

        System.out.print(ans);

    }

        
}
