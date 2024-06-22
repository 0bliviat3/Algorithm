import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        System.out.print(s * 2 - r);
    }
}