import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double d = Double.parseDouble(in.readLine());

        System.out.printf("%.2f", d / 4);
    }
}
