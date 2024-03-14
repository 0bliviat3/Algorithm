import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        int t = Integer.parseInt(in.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String school = null;
            int soju = 0;
            while(n-- > 0) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                String now = st.nextToken();
                int l = Integer.parseInt(st.nextToken());
                if (soju < l) {
                    soju = l;
                    school = now;
                }
            }
            ans.append(school).append('\n');
        }

        System.out.print(ans);
    }
}
