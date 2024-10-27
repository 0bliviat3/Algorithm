import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int sum = 0;
        
        while (n-- > 0) {
            sum += Integer.parseInt(in.readLine());
        }
        
        System.out.print(sum);
    }
}