import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m == 1 || m == 2) {
            System.out.print("NEWBIE!");
        } else if (m <= n) {
            System.out.print("OLDBIE!");
        } else {
            System.out.print("TLE!");
        }
    }
}
