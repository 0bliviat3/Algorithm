import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int chi = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int drink = Integer.parseInt(st.nextToken()) / 2;
        drink += Integer.parseInt(st.nextToken());

        if (chi < drink) {
            System.out.print(chi);
            return;
        }
        System.out.print(drink);
    }
}
