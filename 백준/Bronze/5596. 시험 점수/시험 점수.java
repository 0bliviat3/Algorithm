import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] sum = new int[2];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            while (st.hasMoreTokens()) {
                sum[i] += Integer.parseInt(st.nextToken()); 
            }
        }
        System.out.print(Math.max(sum[0], sum[1]));
    }
}
