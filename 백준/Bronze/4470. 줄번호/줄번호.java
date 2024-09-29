import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        
        for (int i = 1; i <= n; i++) {
            ans.append(i).append(". ").append(in.readLine()).append('\n');
        }
        
        System.out.print(ans);
    }
}