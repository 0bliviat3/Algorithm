import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int sum = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        sum -= Integer.parseInt(st.nextToken());

        if (sum < 0) {
            System.out.print(0);
            return;
        }
        System.out.print(sum);
    }
}
