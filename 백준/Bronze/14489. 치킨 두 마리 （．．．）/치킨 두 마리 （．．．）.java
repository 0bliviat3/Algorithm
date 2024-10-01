import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int sum = Integer.parseInt(st.nextToken());
        sum += Integer.parseInt(st.nextToken());

        int chi = Integer.parseInt(in.readLine()) << 1;

        if (sum < chi) {
            System.out.print(sum);
            return;
        }
        System.out.print(sum - chi);
    }
}
