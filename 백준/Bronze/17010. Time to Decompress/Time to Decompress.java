import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            String val = st.nextToken();
            
            while (cnt-- > 0) {
                ans.append(val);
            }
            ans.append('\n');
        }
        
        System.out.print(ans);
    }
}