import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String input = in.readLine();

        if (input.charAt(n - 1) == 'G') {
            System.out.print(input.substring(0, n - 1));
            return;
        }
        System.out.print(input + "G");
    }
}