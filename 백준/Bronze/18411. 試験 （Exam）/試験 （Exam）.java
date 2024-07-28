import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int min = Integer.MAX_VALUE;

        int sum = 0;
        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            sum += val;
            min = Math.min(min, val);
        }

        System.out.print(sum - min);
    }
}
