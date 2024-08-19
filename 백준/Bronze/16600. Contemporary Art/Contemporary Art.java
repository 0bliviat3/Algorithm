import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double val = Double.parseDouble(in.readLine());
        val = Math.sqrt(val);
        System.out.print(val * 4);
    }
}
