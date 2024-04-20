import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        /*56U R + 24T R + 14U O + 6T O*/
        int sum = 0;
        sum += Integer.parseInt(st.nextToken()) * 56;
        sum += Integer.parseInt(st.nextToken()) * 24;
        sum += Integer.parseInt(st.nextToken()) * 14;
        sum += Integer.parseInt(st.nextToken()) * 6;
        System.out.print(sum);
    }
}