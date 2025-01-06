import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(in.readLine());

        a = Math.sqrt(a / Math.PI);

        System.out.print(a * 2 * Math.PI);
    }
}