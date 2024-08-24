import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int now = 0;

        while (n-- > 0) {
            now += Integer.parseInt(st.nextToken());
        }

        if (now < 0) {
            System.out.print("Left");
        } else if (now > 0) {
            System.out.print("Right");
        } else if (now == 0) {
            System.out.print("Stay");
        }
    }
}
