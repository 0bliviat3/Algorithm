import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int max = 0;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int sum = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}