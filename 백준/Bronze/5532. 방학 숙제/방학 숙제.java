import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(in.readLine());
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());
        int d = Integer.parseInt(in.readLine());

        int max = a / c + ((a % c > 0) ? 1 : 0);
        max = Math.max(max, b / d + ((b % d > 0) ? 1 : 0));
        System.out.print(l - max);
    }
}