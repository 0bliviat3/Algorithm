import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(in.readLine());
        int q = Integer.parseInt(in.readLine());

        if (p <= 50 && q <= 10) {
            System.out.print("White");
        } else if (q > 30) {
            System.out.print("Red");
        } else {
            System.out.print("Yellow");
        }
    }
}