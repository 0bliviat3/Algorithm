import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int time = 0;
        StringTokenizer st = new StringTokenizer(in.readLine());
        while (st.hasMoreTokens()) {
            time += Integer.parseInt(st.nextToken());
        }

        time += (n - 1) * 8;

        System.out.print(time / 24 + " " + time % 24);
    }
}
