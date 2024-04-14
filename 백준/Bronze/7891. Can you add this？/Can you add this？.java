import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            Long a = Long.parseLong(st.nextToken());
            a += Long.parseLong(st.nextToken());
            ans.append(a).append('\n');
        }
        System.out.print(ans);
    }
}