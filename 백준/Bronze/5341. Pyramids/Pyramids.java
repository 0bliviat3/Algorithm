import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String input = null;
        
        while (!(input = in.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            int sum = n;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            ans.append(sum).append('\n');
        }
        
        System.out.print(ans);
    }
}