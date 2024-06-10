import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(in.readLine());

        int mod = b / 11;

        System.out.print(b - mod);
    }
}
