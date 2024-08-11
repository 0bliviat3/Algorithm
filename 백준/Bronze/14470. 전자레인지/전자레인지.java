import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int now = Integer.parseInt(in.readLine());
        int target = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());
        int d = Integer.parseInt(in.readLine());
        int e = Integer.parseInt(in.readLine());

        if (now > 0) {
            System.out.print((target - now) * e);
            return;
        }
        System.out.print(Math.abs(now) * c + d + target * e);
    }
}
