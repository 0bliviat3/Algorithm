import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals("9")) {
                System.out.print("F");
                return;
            }
        }
        System.out.print("S");
    }
}