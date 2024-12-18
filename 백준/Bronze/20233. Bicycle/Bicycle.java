import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int x = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int y = Integer.parseInt(in.readLine());

        int t = Integer.parseInt(in.readLine());

        System.out.printf("%d %d", (a + Math.max(t - 30, 0) * x * 21), (b + Math.max(t - 45, 0) * y * 21));
    }
}