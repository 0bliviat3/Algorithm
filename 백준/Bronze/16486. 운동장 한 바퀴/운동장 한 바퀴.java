import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double d1 = Double.parseDouble(in.readLine());
        double d2 = Double.parseDouble(in.readLine());

        double sum = d1 * 2 + d2 * 2 * 3.141592;

        System.out.print(sum);
    }
}
