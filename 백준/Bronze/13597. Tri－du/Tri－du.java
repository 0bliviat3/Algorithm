import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int max = Math.max(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        System.out.print(max);
    }
}